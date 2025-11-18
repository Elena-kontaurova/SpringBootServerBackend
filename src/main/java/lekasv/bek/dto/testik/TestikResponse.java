package lekasv.bek.dto.testik;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class TestikResponse {
    private int id;
    private String name;
    private int age;
}
