package lekasv.bek.repository;

import lekasv.bek.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByTaskId(Integer taskId);
}
