package hw.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    private String title;
    private String content;
    private int count;
    private LocalDateTime firstCreate;
    private LocalDateTime SecondCreate;


    @OneToMany(mappedBy = "board")
    @JsonManagedReference
    private List<Comment> commentList = new ArrayList<Comment>();

}
