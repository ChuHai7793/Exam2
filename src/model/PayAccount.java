package model;

public class PayAccount extends BankAccount {

    private String cardNo;
    private double balance;

    public PayAccount() {
    }

    public PayAccount(String cardNo, double balance) {
        this.cardNo = cardNo;
        this.balance = balance;
    }

    public PayAccount(int accountID, String accountCode, String accountOwner, String dateCreated, String cardNo, double balance) {
        super(accountID, accountCode, accountOwner, dateCreated);
        this.cardNo = cardNo;
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "PayAccount{" +
                "accountID='" + this.getAccountID() + '\'' +
                ", accountCode='" + this.getAccountCode() + '\'' +
                ", accountOwner='" + this.getAccountOwner() + '\'' +
                ", dateCreated='" + this.getDateCreated() + '\'' +
                "cardNo='" + cardNo + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public String display() {
        return "PayAccount{" +
                "accountID='" + this.getAccountID() + '\'' +
                ", accountCode='" + this.getAccountCode() + '\'' +
                ", accountOwner='" + this.getAccountOwner() + '\'' +
                ", dateCreated='" + this.getDateCreated() + '\'' +
                "cardNo='" + cardNo + '\'' +
                ", balance=" + balance +
                '}';

    }
}


