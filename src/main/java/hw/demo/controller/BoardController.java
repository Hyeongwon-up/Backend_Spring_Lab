package hw.demo.controller;


import hw.demo.dto.BoardDto;
import hw.demo.entity.Board;
import hw.demo.service.BoardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiOperation("board")
@RestController
public class BoardController {


    @Autowired
    BoardService boardService;

    @PostMapping("/Board")
    public void createPost(BoardDto boardDto) {
        boardService.createPost(boardDto);
        System.out.println(boardDto+"저장완료");
    }
}
