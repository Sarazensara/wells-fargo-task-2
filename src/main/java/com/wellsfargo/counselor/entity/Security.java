package com.wellsfargo.task2.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Represents a financial security (e.g., stock or bond) in a portfolio.
 * Each security belongs to one portfolio.
 */
@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    // Core fields describing the security
    private String name;
    private String category;

    private LocalDate purchaseDate;
    private double purchasePrice;
    private int quantity;

    /**
     * Many securities belong to one portfolio.
     */
    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    // --------- Constructors ---------

    public Security() {}  // Default constructor for JPA

    /**
     * Constructor to initialize all fields except ID.
     */
    public Security(String name, String category, LocalDate purchaseDate,
                    double purchasePrice, int quantity, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    // --------- Getters ---------

    public Long getSecurityId() {
        return securityId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    // --------- Setters ---------

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
