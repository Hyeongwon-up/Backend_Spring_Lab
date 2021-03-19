package hw.demo.controller;


import hw.demo.dto.BoardDto;
import hw.demo.entity.Board;
import hw.demo.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1.Board"})
@RestController
@CrossOrigin
public class BoardController {
    @Autowired
    BoardService boardService;

    @ApiOperation(value = "전체 게시글 조회", notes = "게시판 내의 모든 글들을 조회하여 List로 return")
    @GetMapping("/Board")
    public List<Board> getBoardAll() {
        List<Board> boardList= boardService.findPostAll();
        return boardList;
    }

    @ApiOperation(value = "Id로 게시글 조회", notes ="게시판의 글 중 Id로 조회하여 return")
    @GetMapping("/Board/{id}")
    public Board getBoardById(@PathVariable int id) {
        Board board = boardService.findPostById(id);
        return board;
    }

    @ApiOperation(value = "게시글 생성하기", notes = "")
    @PostMapping("/Board")
    public void createPost(@RequestBody BoardDto boardDto) {
        Board board = boardService.createPost(boardDto);
        System.out.println(boardDto+"저장완료");
        System.out.println(board.getFirstCreate());
    }


    @ApiOperation(value = "게시글 수정하기", notes = "")
    @PutMapping("/Board/{id}")
    public void editPost(@PathVariable int id, @RequestBody BoardDto boardDto) {
        Board board = boardService.findPostById(id);
        String newTitle = boardDto.getTitle();
        String newContent = boardDto.getContent();
        boardService.updatePost(id, newTitle, newContent);
        System.out.println("수정완료");
    }

    @ApiOperation(value = "게시글 삭제하기", notes = "")
    @DeleteMapping("/Board/{id}")
    public void fake(@PathVariable int id) {
        boardService.deletePost(id);
        System.out.println("삭제완료");
    }
}
