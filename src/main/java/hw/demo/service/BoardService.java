package hw.demo.service;


import hw.demo.dao.BoardRepository;
import hw.demo.dto.BoardDto;
import hw.demo.entity.Board;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.guieffect.qual.AlwaysSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@NoArgsConstructor
public class BoardService {


    @Autowired
    private BoardRepository boardRepository;

    public Board createPost(BoardDto boardDto) {
        Board board = boardDto.toEntity();
        boardRepository.save(board);
        return board;
    }




}
