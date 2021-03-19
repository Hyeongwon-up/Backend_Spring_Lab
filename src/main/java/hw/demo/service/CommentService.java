package hw.demo.service;


import hw.demo.dao.CommentRepository;
import hw.demo.dto.CommentReqDto;
import hw.demo.entity.Comment;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@NoArgsConstructor
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BoardService boardService;


    public Comment createComment(int id , CommentReqDto commentReqDto) {
        Comment comment = commentReqDto.toEntity();
        comment.setBoard(boardService.findPostById(id));
        commentRepository.save(comment);
        return comment;
    }
}
