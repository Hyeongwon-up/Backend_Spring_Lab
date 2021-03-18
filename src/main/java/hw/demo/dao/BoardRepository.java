package hw.demo.dao;

import hw.demo.dto.BoardDto;
import hw.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Optional<Board> findByName(String name);
}
