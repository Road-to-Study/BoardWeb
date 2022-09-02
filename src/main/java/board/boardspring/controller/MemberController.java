package board.boardspring.controller;

import board.boardspring.domain.Member;
import board.boardspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/signup")
    public String signup() {

        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(Member member) {
        if(memberService.validateDuplicate(member.getId())) {
            return "signup";
        }
        if(!memberService.checkIdForm(member.getId())) {
            return "signup";
        }
        if(!memberService.checkPasswordForm(member.getPassword())) {
            return "signup";
        }

        memberService.join(member);

        return "redirect:/";
    }
}
