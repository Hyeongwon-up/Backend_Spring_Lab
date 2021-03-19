package hw.demo.service;

import hw.demo.dao.CommentRepository;
import hw.demo.dto.BoardDto;
import hw.demo.dto.CommentReqDto;
import hw.demo.entity.Board;
import hw.demo.entity.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;





@SpringBootTest
@Transactional
class CommentServiceTest {


    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BoardService boardService;

    @Autowired
    CommentService commentService;


    @Test
    void 댓글생성() {
        BoardDto boardDto = new BoardDto();
        boardDto.setName("testName1");
        boardDto.setTitle("testTitle1");
        boardDto.setCount(3);
        Board check = boardService.createPost(boardDto);


        int id = check.getId();


        CommentReqDto comment = new CommentReqDto();
        comment.setCommentContent("testComment");
        comment.setCommentName("testname");
        Comment check2 = commentService.createComment(id,comment);

    }













}