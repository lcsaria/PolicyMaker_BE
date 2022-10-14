package com.example.policy_admin_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policyHolder")
public class PolicyHolder {
    @Id
    @Column(name = "policyNumber")
    private String policyNumber;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "licenseNumber")
    private String licenseNumber;

    @Column(name = "dateIssued")
    private String dateIssued;

    public PolicyHolder() {
    }

    public PolicyHolder(String policyNumber, String firstName, String lastName, String address, String licenseNumber,
            String dateIssued) {
        this.policyNumber = policyNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.licenseNumber = licenseNumber;
        this.dateIssued = dateIssued;
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

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * @return String return the licenseNumber
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * @param licenseNumber the licenseNumber to set
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * @return String return the dateIssued
     */
    public String getDateIssued() {
        return dateIssued;
    }

    /**
     * @param dateIssued the dateIssued to set
     */
    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }

}
