package lekasv.bek.exception.extended.tag;

import lekasv.bek.exception.base.NotFoundException;

public class TagNotFoundException extends NotFoundException {
    public TagNotFoundException() {
        super("Тэг не найден");
    }
}
