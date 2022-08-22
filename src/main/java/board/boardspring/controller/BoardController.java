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

    // 게시글 작성

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/write")
    public String writing(Board board, Model model) {

        boardService.write(board);

        model.addAttribute("message","글 작성 완료!");
        model.addAttribute("Url","/list");

        return "message";
    }

    // 게시글 목록 보기

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "list";
    }


    // 게시글 자세히 보기

    @GetMapping("/board/view")
    public String boardView(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));

        return "view";
    }


    // 게시글 수정

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

    // 게시글 삭제

    @GetMapping("/delete")
    public String boardDelete(Integer id){

        boardService.boardDelete(id);
        return "redirect:/list";
    }



}
