package pl.backend.taskmanager.controller;

import org.springframework.web.bind.annotation.*;
import pl.backend.taskmanager.exception.ResourceNotFoundException;
import pl.backend.taskmanager.model.User;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("/users")

public class UserController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @GetMapping(value = "")
    public List<User> getAllUsers() {
        LOGGER.info("Receiving all users");
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getOneUser(@PathVariable Long id) {
        LOGGER.info("Receiving user for id=" + id);
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @GetMapping(value = "", params = {"mail"})
    public User getUserByMail(String mail) {
        LOGGER.info("Receiving user for mail=" + mail);
        return userRepository.findByMail(mail);
    }

    @GetMapping(value = "", params = {"firstName"})
    public User getUserByFirstName(String firstName) {
        LOGGER.info("Receiving user with firstName=" + firstName);
        return userRepository.findByFirstName(firstName);
    }

    @GetMapping(value = "", params = {"lastName"})
    public User getUserByLastName(String lastName) {
        LOGGER.info("Receiving user with lastName=" + lastName);
        return userRepository.findByLastName(lastName);
    }

    @GetMapping(value = "", params = {"login"})
    public User getUserByLogin(String login) {
        LOGGER.info("Receiving user with login=" + login);
        return userRepository.findByLogin(login);
    }

    @GetMapping(value = "", params = {"role"})
    public List<User> getUsersByRole(String role) {
        LOGGER.info("Receiving users for role=" + role);
        return userRepository.findByRole(role);
    }

    @GetMapping(value = "", params = {"reportingTo"})
    public List<User> getUsersByReportingToFirstName(String firstName) {
        LOGGER.info("Receiving users reporting to=" + firstName);
        return userRepository.findByReportingTo(getUserByFirstName(firstName));
    }

    @PostMapping(value = "")
    public User addUser(@RequestBody User user) {
        LOGGER.info("Adding new User: " + user);
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUseData(@RequestBody User user, @PathVariable Long id) {
        LOGGER.info("Updating user's data for id=" + id);
        User updatedUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setMailAddress(user.getMailAddress());
        updatedUser.setReportingTo(user.getReportingTo());
        updatedUser.setRole(user.getRole());
        System.out.println(userRepository.save(updatedUser));
        return updatedUser;
    }
}