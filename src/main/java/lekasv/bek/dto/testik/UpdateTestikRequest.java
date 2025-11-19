package lekasv.bek.dto.testik;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateTestikRequest {

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer age;
}
