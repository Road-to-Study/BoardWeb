package board.boardspring.service;

import board.boardspring.domain.Board;
import board.boardspring.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Board> findBoards() {
        return boardRepository.findAll();
    }



    public Board boardView(Integer id){

        return boardRepository.findById(id).get();
    }
}
