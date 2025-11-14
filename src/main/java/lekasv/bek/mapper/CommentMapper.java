package lekasv.bek.mapper;
import lekasv.bek.model.Comment;
import lekasv.bek.dto.comment.CommentResponse;
import lekasv.bek.dto.comment.CreateCommentRequest;
import lekasv.bek.dto.comment.UpdateCommentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment fromCreateCommentRequest(CreateCommentRequest request);
    void fromUpdateCommentRequest(UpdateCommentRequest request, @MappingTarget Comment comment);
    CommentResponse toCommentResponse(Comment comment);
}
