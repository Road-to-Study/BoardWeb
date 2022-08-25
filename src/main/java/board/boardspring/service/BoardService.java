package board.boardspring.service;

import board.boardspring.domain.Board;
import board.boardspring.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    // 글 작성
    public void write(Board board) {

        boardRepository.save(board);
    }

    // 게시글 처리
    public Page<Board> findBoards(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }


    // 특정 게시물 불러오기
    public Board boardView(Integer id){

        return boardRepository.findById(id).get();
    }

    // 특정 게시글 삭제

    public void boardDelete(Integer id){

        boardRepository.deleteById(id);
    }



}
