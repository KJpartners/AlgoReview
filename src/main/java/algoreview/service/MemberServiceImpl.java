package algoreview.service;

import algoreview.domain.Member;
import algoreview.domain.MemberDTO;
import algoreview.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import algoreview.repository.MemberRepository;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
    /*
     * Jpa 를 사용할 때 EntityManager 를 통해 객체를 영속성 컨텍스트에 저장하거나 객체를 탐색하여 사용한다.
     * 영속성 컨텍스트 : 엔티티를 영구 저장하는 공간, 가상의 DB 역할을 수행, 생명주기가 있음
     * find(class 이름, 기본키) : 해당 엔티티를 찾아 반환, 엔티티는 영속성 컨텍스트의 관리 범위 밖에 있을 수도 있다...
     * persist(객체) : 영속성 컨텍스트에 객체를 저장
     * */

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberMapper memberMapper;

    //MyBatis 를 이용한 데이터 접근 방법
    @Override
    public MemberDTO save(MemberDTO member) {
        memberMapper.save(member);
        return member;
    }

    //Jpa 를 이용한 데이터 접근 방법
    @Override
    public MemberDTO jpaSave(MemberDTO dto) {
        //DTO -> Entity
        Member member = Member.toEntity(dto);
        memberRepository.save(member);

        return dto;
    }

    public MemberDTO find(MemberDTO dto){
        memberMapper.find(dto.getMem_num());

        return dto;
    }
}
