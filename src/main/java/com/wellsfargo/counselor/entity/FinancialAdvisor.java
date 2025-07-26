package com.wellsfargo.task2.entities;

// JPA annotations and collection imports
import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a Financial Advisor in the system.
 * Each advisor can manage multiple clients.
 */
@Entity  // Marks this class as a JPA entity (mapped to a table)
public class FinancialAdvisor {

    @Id  // Primary key for this entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incremented ID
    private Long advisorId;

    // Basic fields that store advisor's information
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    /**
     * One advisor can have many clients.
     * This establishes a one-to-many relationship.
     * The 'mappedBy' attribute tells JPA that the 'advisor' field in Client owns the relationship.
     */
    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Client> clients;

    /**
     * Default no-argument constructor required by JPA.
     */
    public FinancialAdvisor() {}

    /**
     * Constructor to initialize a new FinancialAdvisor (excluding the auto-generated ID).
     */
    public FinancialAdvisor(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    // --------- GETTERS ---------

    public Long getAdvisorId() {
        return advisorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Client> getClients() {
        return clients;
    }

    // --------- SETTERS ---------
    // Note: No setter for advisorId, since it's auto-generated.

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
