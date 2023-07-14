package AlgoReview.mapper;


import AlgoReview.domain.MemberDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper  {
    @Insert("INSERT INTO algo(name) VALUES (#{name})")
    void save(MemberDTO member);

    @Select("SELECT mem_num ,name FROM algo WHERE mem_num = #{mem_num}")
    MemberDTO find(Integer mem_num);

}
