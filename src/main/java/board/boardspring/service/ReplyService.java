package board.boardspring.service;

import board.boardspring.domain.Reply;
import board.boardspring.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public void write(Reply reply) {
        replyRepository.save(reply);
    }

    public List<Reply> findReplyByBoardId(Integer boardId) {
        return replyRepository.findByBoardId(boardId);
    }
}
