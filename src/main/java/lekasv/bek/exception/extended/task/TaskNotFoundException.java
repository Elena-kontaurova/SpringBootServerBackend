package lekasv.bek.exception.extended.task;

import lekasv.bek.exception.base.NotFoundException;

public class TaskNotFoundException extends NotFoundException {
    public TaskNotFoundException() {
        super(" Задача не найдена");
    }
}
