package com.assessment.transaction;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Record {
    @Id
    private int accountNumber;
    private double trxAmount;
    private String description;
    private String trxDate;
    private String trxTime;
    private int customerId;
    private int version; // Optimistic locking version field

    public Record(int accountNumber, double trxAmount, String description, String trxDate, String trxTime, int customerId, int version) {
        this.accountNumber = accountNumber;
        this.trxAmount = trxAmount;
        this.description = description;
        this.trxDate = trxDate;
        this.trxTime = trxTime;
        this.customerId = customerId;
        this.version = version;
    }

    public Record() {

    }

    // Getter and Setter methods

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getTrxAmount() {
        return trxAmount;
    }

    public void setTrxAmount(double trxAmount) {
        this.trxAmount = trxAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public String getTrxTime() {
        return trxTime;
    }

    public void setTrxTime(String trxTime) {
        this.trxTime = trxTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Record{" +
                "accountNumber=" + accountNumber +
                ", trxAmount=" + trxAmount +
                ", description='" + description + '\'' +
                ", trxDate='" + trxDate + '\'' +
                ", trxTime='" + trxTime + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}


