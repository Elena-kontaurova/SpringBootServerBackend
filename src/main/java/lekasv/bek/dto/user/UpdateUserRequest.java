package lekasv.bek.dto.user;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateUserRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\\\s-]+$")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\\\s-]+$")
    private String lastName;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer age;

    @NotNull
    private Boolean active;

    @NotNull
    private Integer roleId;
}
