package AlgoReview.domain;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class MemberDTO {
    private Integer mem_num;
    private String name;

    public static MemberDTO toDTO(Member entity){
        return MemberDTO.builder()
                .mem_num(entity.getMem_num())
                .name(entity.getName())
                .build();
    }

    public MemberDTO() {
    }

    public MemberDTO(String name) {
        this.name = name;
    }

    public MemberDTO(Integer mem_num, String name) {
        this.mem_num = mem_num;
        this.name = name;
    }
}
