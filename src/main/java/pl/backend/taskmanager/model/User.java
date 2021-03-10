package pl.backend.taskmanager.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String password;
    private String mailAddress;
    private String firstName;
    private String lastName;
    private String role;

    @ManyToOne
    private User reportingTo;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<User> subordinates  = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private Set<Ticket> ticketsCreated  = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private Set<Ticket> ticketsAssigned  = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "comment_id")
    private Set<Comment> commentsCreated = new HashSet<>();


    public User() {
    }

    public User(String login, String password, String mailAddress, String firstName, String lastName, String role) {
        this.login = login;
        this.password = password;
        this.mailAddress = mailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getReportingTo() {
        return reportingTo;
    }

    public void setReportingTo(User reportingTo) {
        this.reportingTo = reportingTo;
    }

    public Set<User> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<User> subordinates) {
        this.subordinates = subordinates;
    }

    public Set<Ticket> getTicketsCreated() {
        return ticketsCreated;
    }

    public void setTicketsCreated(Set<Ticket> ticketsCreated) {
        this.ticketsCreated = ticketsCreated;
    }

    public Set<Ticket> getTicketsAssigned() {
        return ticketsAssigned;
    }

    public void setTicketsAssigned(Set<Ticket> ticketsAssigned) {
        this.ticketsAssigned = ticketsAssigned;
    }

    public Set<Comment> getCommentsCreated() {
        return commentsCreated;
    }

    public void setCommentsCreated(Set<Comment> commentsCreated) {
        this.commentsCreated = commentsCreated;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", reportingTo=" + reportingTo +
                ", subordinates=" + subordinates +
                ", ticketsCreated=" + ticketsCreated +
                ", ticketsAssigned=" + ticketsAssigned +
                ", commentsCreated=" + commentsCreated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
