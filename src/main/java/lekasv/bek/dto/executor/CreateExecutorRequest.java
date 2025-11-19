package lekasv.bek.dto.executor;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateExecutorRequest {

    @NotNull
    private Integer taskId;

    @NotNull
    private Integer executorId;

    @NotNull
    private Integer createdBy;
}
