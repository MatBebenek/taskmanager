package pl.backend.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.taskmanager.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
