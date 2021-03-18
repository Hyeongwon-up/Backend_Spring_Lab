package hw.demo.dto;


import hw.demo.entity.Comment;
import lombok.*;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentReqDto {

    private String commentName;
    private String commentContent;

    public Comment toEntity() {
        return Comment.builder()
                .commentName(this.commentName)
                .commentContent(this.commentContent)
                .build();
    }





}
