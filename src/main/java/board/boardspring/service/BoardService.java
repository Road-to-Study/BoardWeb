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

    public void write(Board board) {

        boardRepository.save(board);
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }
}
