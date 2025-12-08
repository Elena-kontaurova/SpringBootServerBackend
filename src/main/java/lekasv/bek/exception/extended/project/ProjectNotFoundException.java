package lekasv.bek.exception.extended.project;

import lekasv.bek.exception.base.NotFoundException;

public class ProjectNotFoundException extends NotFoundException {
    public ProjectNotFoundException() {
        super("Проект не найден");
    }
}
