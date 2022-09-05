package board.boardspring.controller;


import board.boardspring.domain.Board;

import board.boardspring.domain.Member;
import board.boardspring.repository.MemberRepository;
import board.boardspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

    @Autowired


    @GetMapping("/login")
    public String login() {

        return "login";
    }

    // Login 구현
    @PostMapping("/login")
    public String logincheck(HttpServletRequest httpServletRequest) {
        String ID = httpServletRequest.getParameter("login_id");
        String PWD = httpServletRequest.getParameter("login_pwd");

        boolean success = memberService.logincheck(ID,PWD);



        return "login";
    }



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
        }

        memberService.join(member);

        return "redirect:/";
    }
}