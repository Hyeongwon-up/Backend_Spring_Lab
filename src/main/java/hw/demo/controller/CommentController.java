package hw.demo.controller;


import hw.demo.dao.BoardRepository;
import hw.demo.dto.CommentReqDto;
import hw.demo.entity.Comment;
import hw.demo.service.BoardService;
import hw.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {


    @Autowired
    private CommentService commentService;

    @Autowired
    private BoardRepository boardRepository;


    @PostMapping("/Comment/{boardId}")
    public void createComment(@PathVariable int boardId, CommentReqDto commentReqDto) {
        Comment comment = commentReqDto.toEntity();
        comment.setBoard(boardRepository.findById(boardId).get());
        commentService.createComment(commentReqDto);
    }
}
