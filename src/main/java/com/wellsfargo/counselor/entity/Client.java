package com.wellsfargo.task2.entities;

import jakarta.persistence.*;

/**
 * Represents a client who is managed by a financial advisor.
 * Each client has a one-to-one portfolio.
 */
@Entity  // This class is a JPA entity (maps to a table)
public class Client {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incremented
    private Long clientId;

    // Basic personal info fields
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    /**
     * Many clients belong to one financial advisor.
     * 'JoinColumn' adds a foreign key column to this table.
     */
    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private FinancialAdvisor advisor;

    /**
     * Each client has one portfolio.
     * The relationship is bidirectional and owned by Portfolio.
     */
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    // --------- Constructors ---------

    public Client() {}  // Default constructor required by JPA

    /**
     * Constructor without ID (auto-generated).
     */
    public Client(String firstName, String lastName, String email, String phone, FinancialAdvisor advisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.advisor = advisor;
    }

    // --------- Getters ---------

    public Long getClientId() {
        return clientId;
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

    public FinancialAdvisor getAdvisor() {
        return advisor;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    // --------- Setters ---------

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

    public void setAdvisor(FinancialAdvisor advisor) {
        this.advisor = advisor;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
