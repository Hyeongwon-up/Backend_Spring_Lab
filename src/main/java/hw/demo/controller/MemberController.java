package hw.demo.controller;


import hw.demo.dao.MemberRepository;
import hw.demo.dto.MemberReqDto;
import hw.demo.entity.Member;
import hw.demo.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@ApiOperation(value = "", notes = "멤버")
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @GetMapping("/Member")
    public List<Member> findMember() {
        List<Member> list = memberRepository.findAll();
        return list;
    }

    @PostMapping("/createMember")
    public void createMember(MemberReqDto memberReqDto) {
        memberService.createMember(memberReqDto);
    }
    
}
