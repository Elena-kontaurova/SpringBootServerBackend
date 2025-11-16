package lekasv.bek.controller;

import lekasv.bek.dto.comment.CommentResponse;
import lekasv.bek.dto.comment.CreateCommentRequest;
import lekasv.bek.dto.comment.UpdateCommentRequest;
import lekasv.bek.service.api.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<CommentResponse> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/task_id/{taskId}")
    public List<CommentResponse> findByTaskId(@PathVariable Integer taskId) {
        return commentService.findByTaskId(taskId);
    }

    @PostMapping
    public CommentResponse create(@RequestBody CreateCommentRequest comment) {
        return commentService.create(comment);
    }

    @PutMapping("/comment/{comment_id}")
    public CommentResponse update(@PathVariable Integer comment_id, @RequestBody UpdateCommentRequest comment) {
        return commentService.update(comment, comment_id);
    }

    @DeleteMapping("/comment/{comment_id}")
    public void deleteById(@PathVariable int comment_id) {
        commentService.deleteById(comment_id);
    }
}
