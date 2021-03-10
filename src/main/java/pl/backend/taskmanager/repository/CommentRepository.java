package pl.backend.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import pl.backend.taskmanager.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
