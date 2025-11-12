package lekasv.bek.dto.xyu;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class XyuResponse {
    private int id;
    private String name;
    private int age;
}
