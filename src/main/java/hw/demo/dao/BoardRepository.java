package hw.demo.dao;

import hw.demo.dto.BoardDto;
import hw.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
