package com.wellsfargo.task2.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a client's investment portfolio.
 * Each portfolio belongs to one client and can have many securities.
 */
@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    /**
     * One-to-one relationship with Client.
     * This owns the relationship and uses a foreign key in the Portfolio table.
     */
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    /**
     * One portfolio can have multiple securities.
     * 'mappedBy' means the other side (Security) owns the relationship.
     */
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    // --------- Constructors ---------

    public Portfolio() {}  // Default constructor

    /**
     * Constructor without ID (auto-generated).
     */
    public Portfolio(Client client) {
        this.client = client;
    }

    // --------- Getters ---------

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    // --------- Setters ---------

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
