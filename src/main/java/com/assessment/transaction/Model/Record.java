package com.assessment.transaction.Model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;

    @Column
    private double trxAmount;

    @Column
    private String description;
    @Column
    private String trxDate;

    @Column
    private String trxTime;

    @Column
    private int customerId;

    //  private int version; // Optimistic locking version field

    //constructor


    public Record(long id, long accountNumber, double trxAmount, String description, String trxDate, String trxTime, int customerId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.trxAmount = trxAmount;
        this.description = description;
        this.trxDate = trxDate;
        this.trxTime = trxTime;
        this.customerId = customerId;
    }

    public Record() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    // Getter and Setter methods
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
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


//    @Override
//    public String toString() {
//        return "Record{" +
//                "accountNumber=" + accountNumber +
//                ", trxAmount=" + trxAmount +
//                ", description='" + description + '\'' +
//                ", trxDate='" + trxDate + '\'' +
//                ", trxTime='" + trxTime + '\'' +
//                ", customerId=" + customerId +
//                '}';
//    }
}

