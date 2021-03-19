package hw.demo.controller;


import hw.demo.dao.BoardRepository;
import hw.demo.dto.CommentReqDto;
import hw.demo.entity.Comment;
import hw.demo.service.BoardService;
import hw.demo.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"2.Comment"})
@RestController
public class CommentController {


    @Autowired
    private CommentService commentService;

    @Autowired
    private BoardRepository boardRepository;


    @PostMapping("/Comment/{boardId}")
    public void createComment(@PathVariable int boardId, CommentReqDto commentReqDto) {
        Comment comment = commentReqDto.toEntity();
        commentService.createComment(boardId,commentReqDto);
    }
}
