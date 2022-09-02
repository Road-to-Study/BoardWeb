package board.boardspring.controller;

import board.boardspring.domain.Board;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

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

}
