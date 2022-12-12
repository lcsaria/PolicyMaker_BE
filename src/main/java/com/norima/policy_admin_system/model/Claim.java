package com.norima.policy_admin_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "claim")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "claimNumber")
    private String claimNumber;

    @Column(name = "date")
    private String date;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "damageDescription")
    private String damageDescription;

    @Column(name = "cost")
    private String cost;

    @Column(name = "policyNumber")
    private String policyNumber;

    public Claim() {
    }

    public Claim(String claimNumber, String date, String address, String description, String damageDescription,
            String cost, String policyNumber) {
        this.claimNumber = claimNumber;
        this.date = date;
        this.address = address;
        this.description = description;
        this.damageDescription = damageDescription;
        this.cost = cost;
        this.policyNumber = policyNumber;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the claimNumber
     */
    public String getClaimNumber() {
        return claimNumber;
    }

    /**
     * @param claimNumber the claimNumber to set
     */
    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    /**
     * @return String return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the damageDescription
     */
    public String getDamageDescription() {
        return damageDescription;
    }

    /**
     * @param damageDescription the damageDescription to set
     */
    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    /**
     * @return String return the cost
     */
    public String getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     * @return String return the policyNumber
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * @param policyNumber the policyNumber to set
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

}
