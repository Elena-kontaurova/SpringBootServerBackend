package lekasv.bek.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@Builder
@Jacksonized
public class CommentResponse {
    private Integer id;
    private Integer taskId;
    private Integer createdBy;
    private Integer updatedBy;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
