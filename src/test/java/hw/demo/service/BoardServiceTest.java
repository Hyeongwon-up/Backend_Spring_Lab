package hw.demo.service;

import hw.demo.dao.BoardRepository;
import hw.demo.dto.BoardDto;
import hw.demo.entity.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;

    @Test
    void 글등록() {

        BoardDto boardDto = new BoardDto();
        boardDto.setName("이형원");
        boardService.createPost(boardDto);

        Board find = boardRepository.findByName("이형원").get();
        System.out.println(find);
        System.out.println("######");
        System.out.println(boardDto);
        Assertions.assertEquals(boardDto.getName(), find.getName() );

    }

}