package board.boardspring.repository;

import board.boardspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository  extends JpaRepository<Member, Integer> {

    Optional<Member> findById(String id);



}
