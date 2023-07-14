package AlgoReview.controller;

import AlgoReview.service.MemberService;
import AlgoReview.domain.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;


    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("hello","안녕하세요");

        return "member/login";
    }

    //Mybatis
    @GetMapping("/save")
    public String join(MemberDTO member, HttpServletRequest request, HttpServletResponse response) {
        memberService.save(member);
        return "member/list";
    }
    // JPA
    @GetMapping("/save2")
    public String join2(MemberDTO member, HttpServletRequest request, HttpServletResponse response) {
        memberService.jpaSave(member);
        return "member/list";
    }


}