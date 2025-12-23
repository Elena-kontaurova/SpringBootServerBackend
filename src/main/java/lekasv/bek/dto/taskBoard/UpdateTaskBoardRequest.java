package lekasv.bek.dto.taskBoard;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateTaskBoardRequest {

    @NotBlank
    private String name;
}
