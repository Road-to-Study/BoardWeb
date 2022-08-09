package board.boardspring.controller;

import board.boardspring.domain.Board;
import board.boardspring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/write")
    public String writing(Board board) {

        boardService.write(board);
        return "redirect:/";
    }
}
