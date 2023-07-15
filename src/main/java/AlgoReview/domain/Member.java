package AlgoReview.domain;

import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity //Jpa 가 사용하는 객체임을 의미하는 어노테이션
@Table(name = "algo") // @Table, Column 어노테이션은 클래스,변수가 각각 테이블,컬럼명과 일치하면 생략할 수 있다.
public class Member {

    /*
       @Id 는 primary key 를 나타낸다.
       mysql 에서 기본키 컬럼에 대해서 auto_increment 를 설정하면 데이터베이스에서 자동으로 키 값을 설정한다.
       @GenerationType
         IDENTITY : 기본키 생성을 데이터베이스에 위임 (데이터베이스에서 기본키에 auto_increment 설정 시 해당 설정으로 권한 위임 필수)
         SEQUENCE : 기본키 값을 순서대로 생성
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mem_num;
    private String name;


    public static Member toEntity(MemberDTO dto) {
        return Member.builder()
                .name(dto.getName())
                .build();
    }
}
