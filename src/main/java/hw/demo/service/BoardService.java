package hw.demo.service;


import hw.demo.dao.BoardRepository;
import hw.demo.dto.BoardDto;
import hw.demo.entity.Board;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.guieffect.qual.AlwaysSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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

    public Page<Board> find(String title, String content, Pageable pageable) {
        Page<Board> boardPage;
        //내용으로 검색
        if(title==null && content != null) {
            boardPage=boardRepository.findByContentContaining(content, pageable);
        }
        //제목으로 검색
        else if(content==null && title != null) {
            boardPage=boardRepository.findByTitleContaining(title, pageable);
        }
        //제목+내용으로 검색
        else if(title!=null&&content!=null){
            boardPage=boardRepository.findByContentContainingOrTitleContaining(title, content, pageable);
        }
        //그냥 전체 출력.
        else boardPage = boardRepository.findAll(pageable);

        return boardPage;

    }

    public List<Board> findPostAll() {
        List<Board> boardList = boardRepository.findAllDesc();
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
        board.setSecondCreate(LocalDateTime.now());
        boardRepository.save(board);
        return board;
    }

    public void deletePost(int id) {
        Board board = boardRepository.findById(id).get();
        boardRepository.delete(board);
    }

    public List<Board> searchPost(String keyword) {
        List<Board> boardList = boardRepository.findByTitleContaining(keyword);
        return boardList;
    }


    public Page<Board> getBoardPage(Pageable pageable) {
        Page<Board> boardPage = boardRepository.findAll(pageable);
        return boardPage;
    }




}
