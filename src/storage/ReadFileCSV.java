package storage;

import model.BankAccount;
import model.PayAccount;
import model.SavingAccount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadFileCSV {

    public static final String SEPARATOR = ",";

    public static List<BankAccount> readCsvFile() {
        List<BankAccount> accounts = new LinkedList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(WriteFileCSV.CSV_FILE_PATH));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            accounts = getAccounts(lines);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }


    //    viet 1 ham moi: tach chuoi ra, gan lai thuoc tinh cho doi tuong
    private static List<BankAccount> getAccounts(List<String> strings){
        LinkedList<BankAccount> accounts = new LinkedList<>();
        for (String s : strings) {
            String[] split = s.split(SEPARATOR);
            int id = Integer.parseInt(split[0]);
            String code = split[1];
            String owner = split[2];
            String date = split[3];
            BankAccount account = null;
            if (split.length == 8){
                double amount = Double.parseDouble(split[4]);
                String depositDate = split[5];
                String dueDate = split[6];
                double interest = Double.parseDouble(split[7]);
                account = new SavingAccount(id,code,owner,date,amount,depositDate,dueDate,interest);

            } else if (split.length == 6){
                String cardNo = split[4];
                double balance = Double.parseDouble(split[5]);
                account = new PayAccount(id,code,owner,date,cardNo,balance);

            }
            accounts.add(account);

        }
        return accounts;
    }

    public static void main(String[] args) {
        List<BankAccount> accounts = readCsvFile();
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
}