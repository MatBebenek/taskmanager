package pl.backend.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.taskmanager.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
