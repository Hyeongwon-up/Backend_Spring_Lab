package hw.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Table
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOARD_ID")
    private int id;
    private String name;
    private int count;
    private LocalDateTime firstCreate;
    private LocalDateTime SecondCreate;



}
