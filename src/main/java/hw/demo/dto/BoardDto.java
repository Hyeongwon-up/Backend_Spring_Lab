package hw.demo.dto;


import hw.demo.entity.Board;
import lombok.*;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private String name;
    private int count;

    public Board toEntity() {
        return Board.builder()
                .name(this.name)
                .count(this.count)
                .build();
    }


}
