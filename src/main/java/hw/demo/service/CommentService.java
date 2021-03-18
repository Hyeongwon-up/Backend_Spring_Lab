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


    public Comment createComment(CommentReqDto commentReqDto) {
        Comment comment = commentReqDto.toEntity();
        commentRepository.save(comment);
        return comment;
    }
}
