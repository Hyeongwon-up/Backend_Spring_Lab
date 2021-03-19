package hw.demo.service;


import hw.demo.dao.BoardRepository;
import hw.demo.dto.BoardDto;
import hw.demo.entity.Board;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.guieffect.qual.AlwaysSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@NoArgsConstructor
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;


    public Board findPostById(int id) {
        Board board = boardRepository.findById(id).get();
        return board;
    }


    public Board findPostByName(String name) {
        Board board = boardRepository.findByName(name).get();
        return board;
    }

    public List<Board> findPostAll() {
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }


    public Board createPost(BoardDto boardDto) {
        Board board = boardDto.toEntity();
        boardRepository.save(board);
        return board;
    }

    public Board updatePost(int id, String title, String content) {
        Board board = boardRepository.findById(id).get();
        board.setTitle(title);
        board.setContent(content);
        boardRepository.save(board);
        return board;
    }

    public void deletePost(int id) {
        Board board = boardRepository.findById(id).get();
        boardRepository.delete(board);
    }



}
