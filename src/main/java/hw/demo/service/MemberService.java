package hw.demo.service;


import hw.demo.dao.MemberRepository;
import hw.demo.dto.MemberReqDto;
import hw.demo.entity.Member;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@NoArgsConstructor
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;


    public Member createMember(MemberReqDto memberReqDto) {
        Member member = new Member();
        member = memberReqDto.toEntity();
        return memberRepository.save(member);
    }

}
