package DefiningClassesLab.BankAccount;

import java.util.*;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, BankAccount> BankAccounts = new HashMap<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] inputSplit = input.split(" ");
            String command = inputSplit[0];

            String output = "";
            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                int key = bankAccount.getId();
                BankAccounts.put(key, bankAccount);
                output = "Account ID" + key + " created";
            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(inputSplit[1]);
                BankAccount.setInterest_Rate(interest);
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(inputSplit[1]);
                if (id > BankAccounts.size()) {
                    output = "Account does not exist";
                } else {
                    int amount = Integer.parseInt(inputSplit[2]);
                    BankAccounts.get(id).depositSum(amount);
                    output = String.format("Deposited %d to ID%d",amount,id);
                }
            } else {
                int id = Integer.parseInt(inputSplit[1]);
                if (id > BankAccounts.size()) {
                    output = "Account does not exist";
                } else {
                    int years = Integer.parseInt(inputSplit[2]);
                    double interestRate = BankAccounts.get(id).getInterestRate(years);
                    output = String.format("%.2f",interestRate);
                }
            }
            input = scan.nextLine();
            if (!command.equals("SetInterest")) {
                System.out.println(output);
            }
        }
    }
}
