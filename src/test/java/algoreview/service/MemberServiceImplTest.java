package algoreview.service;

import algoreview.domain.Member;
import algoreview.domain.MemberDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import algoreview.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceImplTest {
    @Autowired
    MemberRepository memberRepository;
    @Test
    public void jpaSave() throws IllegalStateException {
        //given
        MemberDTO dto = new MemberDTO("kim");
        Member entity = Member.toEntity(dto);
        //when
        Member savedMember = memberRepository.save(entity);
        //then


        Member findMember = memberRepository.findById(entity.getMem_num()).get();

        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

}