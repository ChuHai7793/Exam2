package model;

import java.util.Date;

public abstract class BankAccount {
    private int accountID;
    private String accountCode, accountOwner;
    private String dateCreated;

    public BankAccount() {
    }

    public BankAccount(int accountID, String accountCode, String accountOwner, String dateCreated) {
        this.accountID = accountID;
        this.accountCode = accountCode;
        this.accountOwner = accountOwner;
        this.dateCreated = dateCreated;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountID='" + accountID + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", accountOwner='" + accountOwner + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
    public abstract String display();
}
