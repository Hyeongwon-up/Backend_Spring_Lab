package hw.demo.controller;


import hw.demo.dao.BoardRepository;
import hw.demo.dto.BoardDto;
import hw.demo.entity.Board;
import hw.demo.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1.Board"})
@RestController
@CrossOrigin
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;

    @ApiOperation(value = "전체 게시글 조회", notes = "게시판 내의 모든 글들을 조회하여 List로 return")
    @GetMapping("/Board")
    public List<Board> getBoardAll() {
        List<Board> boardList= boardService.findPostAll();
        return boardList;
    }

    @ApiOperation(value = "페이징테스트_v1")
    @GetMapping("/test")
    public Page<Board> test(@PageableDefault(size = 10, sort="firstCreate", direction = Sort.Direction.DESC)Pageable pageable) {
        Page<Board> boardPage = boardService.getBoardPage(pageable);
        return boardPage;
    }

    @GetMapping
    @ApiOperation(value = "검색 + 페이징테스트_v2")
    public Page<Board> multiFind(@RequestParam(required = false) String title, @RequestParam(required = false) String content,
                                    @PageableDefault(size = 10, sort="firstCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        return boardService.find(title, content, pageable);
    }



    @ApiOperation(value = "Id로 게시글 조회", notes ="게시판의 글 중 Id로 조회하여 return")
    @GetMapping("/Board/{id}")
    public Board getBoardById(@PathVariable int id) {
        Board board = boardService.findPostById(id);
        board.setCount(board.getCount()+1);
        boardRepository.save(board);
        return board;
    }

    @ApiOperation(value = "게시글 생성하기")
    @PostMapping("/Board")
    public void createPost(@RequestBody BoardDto boardDto) {
        Board board = boardService.createPost(boardDto);
    }


    @ApiOperation(value = "게시글 수정하기")
    @PutMapping("/Board/{id}")
    public void editPost(@PathVariable int id, @RequestBody BoardDto boardDto) {
        Board board = boardService.findPostById(id);
        String newTitle = boardDto.getTitle();
        String newContent = boardDto.getContent();
        boardService.updatePost(id, newTitle, newContent);
    }

    @ApiOperation(value = "게시글 삭제하기", notes = "")
    @DeleteMapping("/Board/{id}")
    public void fake(@PathVariable int id) {
        boardService.deletePost(id);
    }

    @ApiOperation(value = "게시글 검색", notes = "")
    @GetMapping("/Board/Search")
    public List<Board> searchPost(@RequestParam(value="keyword") String keyword) {
        List<Board> boardList = boardService.searchPost(keyword);
        return boardList;
    }



}
