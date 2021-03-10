package pl.backend.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import pl.backend.taskmanager.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
}
