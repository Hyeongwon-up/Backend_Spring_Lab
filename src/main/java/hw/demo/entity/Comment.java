package hw.demo.entity;


import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private int id;


    private String commentName;

    private String commentContent;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")//FK
    private Board board;








}
