package DefiningClassesLab.BankAccount;

public class BankAccount {
    private
    static double Interest_Rate = 0.2;
    static int bankAccountCount = 1;
    int id;
    double balance;

    public static void setInterest_Rate(double interest) {
        Interest_Rate = interest;
    }

    double getInterestRate(int years) {
        return Interest_Rate * years * balance;
    }
    int getId  (){
        return id;
    }

    void depositSum(double sum) {
        balance += sum;
    }

    BankAccount() {
        id = bankAccountCount++;
    }

}
