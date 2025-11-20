package lekasv.bek.service.impl;

import lekasv.bek.dto.comment.CommentResponse;
import lekasv.bek.dto.comment.CreateCommentRequest;
import lekasv.bek.dto.comment.UpdateCommentRequest;
import lekasv.bek.exception.extended.comment.CommentNotFoundException;
import lekasv.bek.mapper.CommentMapper;
import lekasv.bek.model.Comment;
import lekasv.bek.repository.CommentRepository;
import lekasv.bek.service.api.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public List<CommentResponse> getAll() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toCommentResponse)
                .toList();
    }

    @Override
    public List<CommentResponse> findByTaskId(Integer taskId) {
        return commentRepository.findByTaskId(taskId)
                .stream()
                .map(commentMapper::toCommentResponse)
                .toList();
    }

    @Override
    public CommentResponse create(CreateCommentRequest request) {
        if (request.getDescription() == null || request.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description is null or empty");
        }
        Comment comment = commentMapper.fromCreateCommentRequest(request);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUpdatedAt(LocalDateTime.now());
        commentRepository.save(comment);
        return commentMapper.toCommentResponse(comment);
    }

    @Override
    public CommentResponse update(UpdateCommentRequest request, Integer commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);

        commentMapper.fromUpdateCommentRequest(request, comment);
        comment.setUpdatedAt(LocalDateTime.now());
        commentRepository.save(comment);
        return commentMapper.toCommentResponse(comment);
    }

    @Override
    public void deleteById(Integer commentId) {
        commentRepository.deleteById(commentId);
    }

}
