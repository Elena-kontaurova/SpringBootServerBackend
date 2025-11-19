package lekasv.bek.dto.tag;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateTagRequest {

    @NotBlank
    private String name;

    @NotNull
    private Integer createdBy;

    @NotNull
    private Integer updatedBy;
}
