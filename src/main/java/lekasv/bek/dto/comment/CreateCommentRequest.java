package lekasv.bek.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateCommentRequest {
    private Integer taskId;
    private Integer userId;
    private String description;
}
