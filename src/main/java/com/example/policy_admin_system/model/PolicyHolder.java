package com.example.policy_admin_system.model;

import javax.persistence.Column;
import javax.persistence.Id;

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
    private String dateIsuued;

}
