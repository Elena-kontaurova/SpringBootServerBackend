package lekasv.bek.service.api;

import lekasv.bek.dto.comment.CommentResponse;
import lekasv.bek.dto.comment.CreateCommentRequest;
import lekasv.bek.dto.comment.UpdateCommentRequest;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getAll();
    List<CommentResponse> findByTaskId(Integer taskId);
    CommentResponse create(CreateCommentRequest request);
    CommentResponse update(UpdateCommentRequest request, int commentId);
    void deleteById(int id_comment);
}
