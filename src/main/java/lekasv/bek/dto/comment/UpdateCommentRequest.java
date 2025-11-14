package lekasv.bek.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateCommentRequest {
    private Integer taskId;
    private Integer userId;
    private String description;
}
