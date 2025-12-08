package lekasv.bek.dto.project;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateProjectRequest {

    @NotBlank
    private String name;
}
