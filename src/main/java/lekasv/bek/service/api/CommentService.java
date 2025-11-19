package lekasv.bek.service.api;

import jakarta.validation.Valid;
import lekasv.bek.dto.comment.CommentResponse;
import lekasv.bek.dto.comment.CreateCommentRequest;
import lekasv.bek.dto.comment.UpdateCommentRequest;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface CommentService {
    List<CommentResponse> getAll();
    List<CommentResponse> findByTaskId(Integer taskId);
    CommentResponse create(@Valid CreateCommentRequest request);
    CommentResponse update(@Valid UpdateCommentRequest request, Integer commentId);
    void deleteById(Integer commentId);
}
