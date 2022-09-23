package com.example.policy_admin_system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="policy")
public class Policy {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="entryNo")
    private int entryNo;
    @Column(name = "policyNumber")
    private int policyNumber;
    @Column(name = "effectiveDate")
    private Date effectiveDate;
    @Column(name = "expirationDate")
    private Date  expirationDate;
    @Column(name = "type")
    private int type;
    @Column(name = "vehicles")
    private int vehicles; 


    public Policy() {}

    public Policy(int entryNo, int policyNumber, Date effectiveDate, Date expirationDate, int type, int vehicles){
        this.entryNo = entryNo;
        this.policyNumber = policyNumber;
        this.effectiveDate = effectiveDate;
        this.expirationDate = expirationDate;
        this.type = type;
        this.vehicles = vehicles;
    }
    /**
     * @return int return the entryNo
     */
    public int getEntryNo() {
        return entryNo;
    }

    /**
     * @param entryNo the entryNo to set
     */
    public void setEntryNo(int entryNo) {
        this.entryNo = entryNo;
    }

    /**
     * @return int return the policyNumber
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * @param policyNumber the policyNumber to set
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * @return String return the effectiveDate
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * @param effectiveDate the effectiveDate to set
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * @return String return the expirationDate
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * @return int return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return int return the vehicles
     */
    public int getVehicles() {
        return vehicles;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void setVehicles(int vehicles) {
        this.vehicles = vehicles;
    }

}
