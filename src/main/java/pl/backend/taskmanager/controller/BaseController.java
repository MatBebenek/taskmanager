package pl.backend.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pl.backend.taskmanager.repository.CommentRepository;
import pl.backend.taskmanager.repository.TicketRepository;
import pl.backend.taskmanager.repository.UserRepository;

public abstract class BaseController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    TicketRepository ticketRepository;

}