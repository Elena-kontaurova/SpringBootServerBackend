package lekasv.bek.dto.taskBoard;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class TaskBoardResponse {
    private int id;
    private String name;
}
