package storage;

import model.BankAccount;
import model.PayAccount;
import model.SavingAccount;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WriteFileCSV {
    public static final String CSV_FILE_PATH = "src/data/accounts.csv";
    public static final String NEW_LINE = "\n";
    public static final String SEPARATOR = ",";
//    public static final String FILE_HEADER = "employeeId,employeeName,employeeRole,employeeEmail,baseSalary,Others";

    public static void main(String[] args) {

        BankAccount s1 = new SavingAccount(1,"00345","Nguyen Kieu An",
                "04/05/2020",1500000,"05/05/2020","5",6);
        BankAccount s2 = new SavingAccount(2,"003452","Chu Van An",
                "04/05/2020",1540000,"05/05/2020","5",6);
        BankAccount s3 = new PayAccount(3,"002425","Nguyen Van Binh",
                "04/05/2020","421332423443",2000000);
        List<BankAccount> accounts = new ArrayList<BankAccount>();
        accounts.add(s1);
        accounts.add(s2);
        accounts.add(s3);
        writeToFile( accounts);
    }

    public static void writeToFile( List<BankAccount> accounts) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(CSV_FILE_PATH);
            for (BankAccount account : accounts) {
                String line = account.getAccountID() + SEPARATOR +
                        account.getAccountCode() + SEPARATOR +
                        account.getAccountOwner() + SEPARATOR +
                        account.getDateCreated();

                if (account instanceof PayAccount) {
                    line += SEPARATOR + ((PayAccount) account).getCardNo() +
                            SEPARATOR + ((PayAccount) account).getBalance() +
                            NEW_LINE;
                } else if (account instanceof SavingAccount) {
                    line += SEPARATOR + ((SavingAccount) account).getAmount() +
                            SEPARATOR + ((SavingAccount) account).getDepositDate() +
                            SEPARATOR + ((SavingAccount) account).getDueDate() +
                            SEPARATOR + ((SavingAccount) account).getInterestRate() +
                            NEW_LINE;
                } else {
                    line += NEW_LINE;
                }
                fw.append(line);
//                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}