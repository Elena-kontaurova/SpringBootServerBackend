package lekasv.bek.exception.extended.user;

import lekasv.bek.exception.base.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super("Пользователь не найден");
    }
}
