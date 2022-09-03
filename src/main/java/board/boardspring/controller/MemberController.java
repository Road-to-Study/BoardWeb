package board.boardspring.controller;

import board.boardspring.domain.Member;
import board.boardspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/register")
    public String register() {

        return "register";
    }

    @ResponseBody
    @PostMapping("/register")
    public String signupPost(Member member) {
        if(memberService.validateDuplicate(member.getId())) {
            return "<script>alert('중복된 아이디입니다');location.href='/register'</script>";
        }
        if(!memberService.checkIdForm(member.getId())) {
            return "<script>alert('아이디 형식이 올바르지 않습니다');location.href='/register'</script>";
        }
        if(!memberService.checkPasswordForm(member.getPassword())) {
            return "<script>alert('비밀번호 형식이 올바르지 않습니다');location.href='/register'</script>";
        }

        memberService.join(member);

        return "redirect:/";
    }

}
