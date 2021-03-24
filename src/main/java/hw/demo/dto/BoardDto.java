package hw.demo.dto;


import hw.demo.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private String name;
    private String title;
    private String content;

    public Board toEntity() {
        return Board.builder()
                .name(this.name)
                .title(this.title)
                .content(this.content)
                .count(0)
                .firstCreate(LocalDateTime.now())
                .SecondCreate(LocalDateTime.now())
                .build();
    }


}
