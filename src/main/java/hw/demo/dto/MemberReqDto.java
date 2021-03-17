package hw.demo.dto;

import hw.demo.entity.Member;
import lombok.*;


@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberReqDto {


    private String name;
    private String address;



    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .address(this.address)
                .build();
    }
}
