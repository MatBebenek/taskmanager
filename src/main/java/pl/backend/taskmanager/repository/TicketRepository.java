package pl.backend.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import pl.backend.taskmanager.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
