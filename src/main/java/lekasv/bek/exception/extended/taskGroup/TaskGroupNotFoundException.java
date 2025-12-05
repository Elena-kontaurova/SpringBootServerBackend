package lekasv.bek.exception.extended.taskGroup;

import lekasv.bek.exception.base.NotFoundException;

public class TaskGroupNotFoundException extends NotFoundException {
    public TaskGroupNotFoundException() {
        super("Группа задач не найдена");
    }
}
