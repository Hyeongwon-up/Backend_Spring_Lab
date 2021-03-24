package hw.demo.dao;

import hw.demo.dto.BoardDto;
import hw.demo.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Optional<Board> findByName(String name);
    @Query("SElECT b FROM Board b ORDER BY b.firstCreate DESC")
    List<Board> findAllDesc();
    List<Board> findByTitleContaining(String keyword);
    Page<Board> findAll(Pageable pageable);
    Page<Board> findByTitleContaining(String title, Pageable pageable);
    Page<Board> findByContentContaining(String content, Pageable pageable);
    Page<Board> findByContentContainingOrTitleContaining(String content, String title, Pageable pageable);
}
