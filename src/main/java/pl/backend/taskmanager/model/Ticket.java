package pl.backend.taskmanager.model;

import pl.backend.taskmanager.staticData.PriorityData;
import pl.backend.taskmanager.staticData.StatusData;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private PriorityData priority;
    private StatusData statusData = StatusData.OPEN;
    private String description;
    private Date creationDate;
    private Date updateDate;

    @ManyToOne
    private User reporter;

    @ManyToOne
    private User assignee;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private Set<Comment> comments = new HashSet<>();

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PriorityData getPriority() {
        return priority;
    }

    public void setPriority(PriorityData priority) {
        this.priority = priority;
    }

    public StatusData getStatusData() {
        return statusData;
    }

    public void setStatusData(StatusData statusData) {
        this.statusData = statusData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Ticket(String title, PriorityData priority, StatusData statusData, String description, Date creationDate, Date updateDate) {
        this.title = title;
        this.priority = priority;
        this.statusData = statusData;
        this.description = description;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                ", statusData=" + statusData +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", reporter=" + reporter +
                ", assignee=" + assignee +
                ", comments=" + comments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
