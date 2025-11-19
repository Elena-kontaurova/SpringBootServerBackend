package lekasv.bek.dto.task;

import lekasv.bek.enums.TaskStatucEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Getter
@Builder
@Jacksonized
public class TaskResponse {
    private Integer id;
    private String name;
    private String description;
    private TaskStatucEnum status;
    private Integer userId;
    private Integer parentTaskId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer createdBy;
    private Integer updatedBy;
}
