package board.boardspring.controller;

<<<<<<< HEAD

import board.boardspring.domain.Board;

=======
>>>>>>> 992ff8aaf832a6aef402bbc6e5af1c99404b2eb3
import board.boardspring.domain.Member;
import board.boardspring.repository.MemberRepository;
import board.boardspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

=======
>>>>>>> 992ff8aaf832a6aef402bbc6e5af1c99404b2eb3
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

    @Autowired
<<<<<<< HEAD

=======
    private MemberService memberService;
>>>>>>> 992ff8aaf832a6aef402bbc6e5af1c99404b2eb3

    @GetMapping("/login")
    public String login() {

        return "login";
    }

<<<<<<< HEAD
    // Login 구현
    @PostMapping("/login")
    public String logincheck(HttpServletRequest httpServletRequest) {
        String ID = httpServletRequest.getParameter("login_id");
        String PWD = httpServletRequest.getParameter("login_pwd");

        boolean success = memberService.logincheck(ID,PWD);
=======
    @GetMapping("/register")
    public String register() {
>>>>>>> 992ff8aaf832a6aef402bbc6e5af1c99404b2eb3



        return "login";
    }

<<<<<<< HEAD


    @Autowired
    private MemberService memberService;

    @GetMapping("/register")
    public String signup() {

        return "register";
    }

    @PostMapping("/register")
    public String signupPost(Member member) {
        if (memberService.validateDuplicate(member.getId())) {
            return "register";
        }
        if (!memberService.checkIdForm(member.getId())) {
            return "register";
        }
        if (!memberService.checkPasswordForm(member.getPassword())) {
            return "register";
=======
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
>>>>>>> 992ff8aaf832a6aef402bbc6e5af1c99404b2eb3
        }

        memberService.join(member);

        return "redirect:/";
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> 992ff8aaf832a6aef402bbc6e5af1c99404b2eb3
