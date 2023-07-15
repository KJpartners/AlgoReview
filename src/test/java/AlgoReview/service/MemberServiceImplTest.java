package AlgoReview.service;

import AlgoReview.AlgoReviewApplication;
import AlgoReview.domain.Member;
import AlgoReview.domain.MemberDTO;
import AlgoReview.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

//@RunWith(SpringRunner.class)
//@TestPropertySource(locations="application.yml")
@SpringBootTest(classes = AlgoReviewApplication.class)
@Transactional
class MemberServiceImplTest {
    @Autowired
    private MemberRepository memberRepository;
    @Test
    void jpaSave() {
        //given
        MemberDTO dto = new MemberDTO("kim");

        //when
        Member member = Member.toEntity(dto);
        Member SaverdMember = memberRepository.save(member);

        //then
        Member FindMember = memberRepository.findById(member.getMem_num()).get();
        Assertions.assertThat(FindMember).isEqualTo(SaverdMember);


    }


}