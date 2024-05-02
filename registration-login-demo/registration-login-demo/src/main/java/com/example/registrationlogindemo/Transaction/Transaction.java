package com.example.registrationlogindemo.Transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    //Account register
    private int id;
    /*private String accountNumber;
    private String confirmAccountNumber;
    private String currency;
    private String accountType;*/
    private double balance;

    //View Account Statement
    private Date fromDate;
    private Date toDate;

    //Deposit Amount
    private double depositAmount;
    private String remark;
    private String depositType;

    //Withdraw Amount
    private double withdrawAmount;
    private String withdrawType;


    //Account register
    public Transaction(int id, String accountNumber, String confirmAccountNumber, String currency, String accountType, double balance,
                   Date fromDate, Date toDate,
                   double depositAmount, String remark, String depositType,
                   double withdrawAmount, String withdrawType) {
        super();
        this.id = id;
        /*this.accountNumber = accountNumber;
        this.confirmAccountNumber = confirmAccountNumber;
        this.currency = currency;
        this.accountType = accountType;*/
        this.balance = balance;

        //View Account Statement
        this.fromDate = fromDate;
        this.toDate =toDate;

        //Deposit Amount
        this.depositAmount = depositAmount;
        this.remark = remark;
        this.depositType = depositType;

        //Withdraw Amount
        this.withdrawAmount = withdrawAmount;
        this.withdrawType = withdrawType;
    }



    public Transaction() {
        super();
        // TODO Auto-generated constructor stub
    }


    //Getter And Setter Method
    //Account register
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

   /* public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getConfirmAccountNumber() {
        return confirmAccountNumber;
    }
    public void setConfirmAccountNumber(String confirmAccountNumber) {
        this.confirmAccountNumber = confirmAccountNumber;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }*/

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //View Account Statement

    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    //Deposit Amount

    public double getDepositAmount() {
        return depositAmount;
    }
    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }
    //Withdraw Amount

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(String withdrawType) {
        this.withdrawType = withdrawType;
    }

}