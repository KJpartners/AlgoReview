package AlgoReview.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
    @Value("${jasypt.encryptKey}") // 암호화에 사용하는 키를 환경 변수(jasypt_encryptor_encryptKey)로 등록해서 사용할 경우
    private String encryptKey;

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(encryptKey); //암호화에 사용하는 키
        config.setPoolSize("1"); //인스턴스 풀
        config.setAlgorithm("PBEWithMD5AndDES"); // 암호화에 사용하는 알고리즘
        config.setStringOutputType("base64"); //인코딩 타입
        config.setKeyObtentionIterations("1000"); // 반복할 해싱 횟수
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        encryptor.setConfig(config); //설정 정보 저장
        return encryptor;
    }
}
