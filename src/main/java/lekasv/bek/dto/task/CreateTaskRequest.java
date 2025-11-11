package lekasv.bek.dto.task;

import lekasv.bek.Enum.TaskStatucEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateTaskRequest {
    private String name;
    private String description;
    private TaskStatucEnum status;
    private int userId;
}
