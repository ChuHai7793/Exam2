package model;

public class SavingAccount extends BankAccount {

    private double amount;
    private String depositDate,dueDate;
    private double interestRate;

    public SavingAccount() {
    }

    public SavingAccount(int accountID, String accountCode, String accountOwner, String dateCreated,
                         double amount, String depositDate, String dueDate, double interestRate) {
        super(accountID, accountCode, accountOwner, dateCreated);
        this.amount = amount;
        this.depositDate = depositDate;
        this.dueDate = dueDate;
        this.interestRate = interestRate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "accountID='" + this.getAccountID() + '\'' +
                ", accountCode='" + this.getAccountCode() + '\'' +
                ", accountOwner='" + this.getAccountOwner() + '\'' +
                ", dateCreated='" + this.getDateCreated() + '\'' +
                "amount='" + amount + '\'' +
                ", depositDate='" + depositDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", interestRate=" + interestRate +
                '}';
    }
    @Override
    public String display() {
        return "SavingAccount{" +
                "accountID='" + this.getAccountID() + '\'' +
                ", accountCode='" + this.getAccountCode() + '\'' +
                ", accountOwner='" + this.getAccountOwner() + '\'' +
                ", dateCreated='" + this.getDateCreated() + '\'' +
                "amount='" + amount + '\'' +
                ", depositDate='" + depositDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", interestRate=" + interestRate +
                '}';
    }
}
