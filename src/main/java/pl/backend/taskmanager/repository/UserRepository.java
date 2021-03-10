package pl.backend.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.taskmanager.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByReportingTo(User reportingTo);
    List<User> findByRole(String role);

    User findByLogin(String login);
    User findByMail(String mail);
    User findByFirstName(String firstName);
    User findByLastName(String lastName);
}
