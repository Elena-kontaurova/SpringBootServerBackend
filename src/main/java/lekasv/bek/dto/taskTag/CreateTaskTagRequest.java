package lekasv.bek.dto.taskTag;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
public class CreateTaskTagRequest {

    @NotNull
    private Integer tagId;

    @NotNull
    private Integer taskId;

    @NotNull
    private Integer createdBy;
}
