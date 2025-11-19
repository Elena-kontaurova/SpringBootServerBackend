package lekasv.bek.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lekasv.bek.enums.TaskStatucEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateTaskRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private TaskStatucEnum status;

    @NotNull
    private Integer userId;
    private Integer parentTaskId;

    @NotNull
    private Integer createdBy;

    @NotNull
    private Integer updatedBy;
}
