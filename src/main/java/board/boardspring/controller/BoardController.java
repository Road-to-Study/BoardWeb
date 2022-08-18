package board.boardspring.controller;

import board.boardspring.domain.Board;
import board.boardspring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "list";
    }


    @GetMapping("/board/view")
    public String boardView(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));

        return "view";
    }

    @GetMapping("modify/{id}")
    public String modify(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("board", boardService.boardView(id));

        return "modify";
    }

    @PostMapping("/modify/{id}")
    public String modifying(@PathVariable("id") Integer id, Board board) {

        Board oldBoard = boardService.boardView(id);
        oldBoard.setTitle(board.getTitle());
        oldBoard.setContent(board.getContent());

        boardService.write(oldBoard);

        return "redirect:/list";
    }
}
