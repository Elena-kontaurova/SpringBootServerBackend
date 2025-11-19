package lekasv.bek.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateCommentRequest {

    @NotNull
    private Integer taskId;

    @NotNull
    private Integer createdBy;

    @NotNull
    private Integer updatedBy;

    @NotBlank
    private String description;
}
