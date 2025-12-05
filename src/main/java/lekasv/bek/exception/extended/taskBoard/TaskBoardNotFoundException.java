package lekasv.bek.exception.extended.taskBoard;

import lekasv.bek.exception.base.NotFoundException;

public class TaskBoardNotFoundException extends NotFoundException {
    public TaskBoardNotFoundException() {
        super("Такая доска не найдена");
    }
}
