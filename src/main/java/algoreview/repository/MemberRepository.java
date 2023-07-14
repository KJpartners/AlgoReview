package algoreview.repository;

import algoreview.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                      //Entity클래스,Entity 주요식별자 type
public interface MemberRepository extends JpaRepository<Member, Integer> {



    //추가메서드
}
