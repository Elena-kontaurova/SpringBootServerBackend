package lekasv.bek.exception.extended.testik;

import lekasv.bek.exception.base.NotFoundException;

public class TestikNotFoundException extends NotFoundException {
    public TestikNotFoundException() {
        super("Тест не найден");
    }
}
