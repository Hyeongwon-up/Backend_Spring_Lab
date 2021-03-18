package hw.demo.service;

import hw.demo.dao.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;





@SpringBootTest
@Transactional
class CommentServiceTest {


    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentService commentService;


    @Test
    void 댓글생성() {








    }













}