package lekasv.bek.dto.taskTag;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@Builder
@Jacksonized
public class TaskTagResponse {
    private int id;
    private Integer tagId;
    private Integer taskId;
    private LocalDateTime createdAt;
    private Integer createdBy;
}
