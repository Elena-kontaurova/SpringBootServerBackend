package lekasv.bek.dto.xyu;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class CreteXyuRequest {
    private String name;
    private int age;
}
