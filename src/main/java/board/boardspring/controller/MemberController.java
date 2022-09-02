package board.boardspring.controller;

<<<<<<< HEAD
import board.boardspring.domain.Board;
=======
import board.boardspring.domain.Member;
import board.boardspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 4f5a33498283ccf9bf47f76b09be9bd21933edac
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

<<<<<<< HEAD
    @GetMapping("/login")
    public String login() {

        return "login";
    }

//    @PostMapping("/login")
//    public String login() {
//
//        return "login";
//    }
//

    @GetMapping("/register")
    public String register() {

        return "register";
    }

//    @PostMapping("/register")
//    public String register() {
//
//        return "register";
//    }

=======
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
>>>>>>> 4f5a33498283ccf9bf47f76b09be9bd21933edac
}
