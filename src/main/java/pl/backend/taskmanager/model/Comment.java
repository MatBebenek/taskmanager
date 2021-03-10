package pl.backend.taskmanager.model;

import pl.backend.taskmanager.staticData.PriorityData;
import pl.backend.taskmanager.staticData.StatusData;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User author;

    @ManyToOne
    private Ticket ticketCommented;

    private Date date;
    private String content;

    public Comment() {
    }

    public Comment(Date date, String content) {
        this.date = date;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Ticket getTicketCommented() {
        return ticketCommented;
    }

    public void setTicketCommented(Ticket ticketCommented) {
        this.ticketCommented = ticketCommented;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author=" + author +
                ", ticketCommented=" + ticketCommented +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
