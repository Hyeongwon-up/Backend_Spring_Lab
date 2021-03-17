package hw.demo.entity;


import lombok.*;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Table
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private int id;
    private String name;
    private String address;

}
