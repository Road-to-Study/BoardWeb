package board.boardspring.repository;

import board.boardspring.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    List<Reply> findByBoardId(Integer boardId);
}
