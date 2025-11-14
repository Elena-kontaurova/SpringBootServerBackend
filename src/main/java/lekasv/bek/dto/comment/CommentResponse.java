package lekasv.bek.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@Builder
@Jacksonized
public class CommentResponse {
    private int id;
    private Integer taskId;
    private Integer userId;
    private String description;
    private LocalDateTime dateTime;
}
