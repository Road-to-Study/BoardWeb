package board.boardspring.controller;

import board.boardspring.domain.Board;
import board.boardspring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public String writing(Board board) {

        boardService.write(board);
        return "redirect:/";
    }
    // 게시글 목록 보기

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(page = 0, size= 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Board> boards = boardService.findBoards(pageable);

        int curPage = boards.getPageable().getPageNumber() +1;
        int startPage = Math.max(curPage - 4, 1);
        int endPage = Math.min(curPage + 5, boards.getTotalPages());

        model.addAttribute("boards", boards);
        model.addAttribute("curPage", curPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
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
