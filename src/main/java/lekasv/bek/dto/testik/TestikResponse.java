package lekasv.bek.dto.testik;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class TestikResponse {
    private Integer id;
    private String name;
    private Integer age;
}
