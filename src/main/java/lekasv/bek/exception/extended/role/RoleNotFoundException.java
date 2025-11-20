package lekasv.bek.exception.extended.role;

import lekasv.bek.exception.base.NotFoundException;

public class RoleNotFoundException extends NotFoundException {
    public RoleNotFoundException() {
        super("Роль не найдена");
    }
}
