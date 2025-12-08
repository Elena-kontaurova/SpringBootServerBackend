package lekasv.bek.dto.project;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateProjectRequest {

    @NotBlank
    private String name;
}
