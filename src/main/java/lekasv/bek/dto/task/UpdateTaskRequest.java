package lekasv.bek.dto.task;

import lekasv.bek.enums.TaskStatucEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateTaskRequest {
    private String name;
    private String description;
    private TaskStatucEnum status;
    private Integer userId;
    private Integer parentTaskId;
    private Integer createdBy;
    private Integer updatedBy;
}
