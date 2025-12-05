package lekasv.bek.dto.taskBoard;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreateTaskBoardRequest {

    @NotBlank
    private String name;
}

