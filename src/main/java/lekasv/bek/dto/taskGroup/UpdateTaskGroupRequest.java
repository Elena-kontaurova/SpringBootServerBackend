package lekasv.bek.dto.taskGroup;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateTaskGroupRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Integer taskBoardId;
}
