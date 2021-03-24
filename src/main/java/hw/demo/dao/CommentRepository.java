package hw.demo.dao;

import hw.demo.entity.Board;
import hw.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {



    List<Comment> findByBoard(Board board);



}
