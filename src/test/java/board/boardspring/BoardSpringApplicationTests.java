package board.boardspring;

import board.boardspring.controller.BoardController;
import board.boardspring.domain.Board;
import board.boardspring.repository.BoardRepository;
import board.boardspring.service.BoardService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootTest
class BoardSpringApplicationTests {



	@Autowired
	BoardService boardService;
	BoardRepository boardRepository;



//	@Test
//	@DisplayName("Board 생성 테스트")
//	public void ID_제목_내용() {
//
//		Board board = new Board();
//
//		board.setId(1);
//		board.setTitle("test title");
//		board.setContent("test content");
//
//
//		Assertions.assertEquals(1, board.getId());
//		Assertions.assertEquals("test title", board.getTitle());
//		Assertions.assertEquals("test content", board.getContent());
//
//	}


//	@Test
//	@DisplayName("글 작성 테스트")
//	public void 글_작성() {
//
//		Board board = new Board();
//
//
//
//		board.setTitle("test title");
//		board.setContent("test content");
//
//		boardService.write(board);
//
//		boardService.boardDelete(15);
//
//	}


}
