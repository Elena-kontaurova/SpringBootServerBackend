package lekasv.bek.exception.extended.comment;

import lekasv.bek.exception.base.NotFoundException;

public class CommentNotFoundException extends NotFoundException {
    public CommentNotFoundException() {
        super("Комментарий не найден");
    }
}
