package classes;

import java.util.Scanner;

public class CheckingAccount extends Account {
    private double negativeBalance = 100;
    private final double totalBalance = balance - negativeBalance;


    public CheckingAccount(String owner, String email, String phoneNumber, double initialBalance) {
        super(owner, email, phoneNumber, "checking", initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 0) {
            setbalance(balance - amount);
            System.out.println("Withdrawal successful. New positive balance: " + getBalance());
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Warning: Withdrawing this amount will result in overdrawing (Any excess amount withdrawn will contribute to your negative balance).");
            System.out.print("Do you want to proceed? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes")) {
                double negativeBalance = getNegativeBalance();
                setNegativeBalance(negativeBalance + (amount - balance));
                System.out.println("Withdrawal successful. New negative balance: " + getNegativeBalance());
            } else {
                System.out.println("Withdrawal cancelled.");
            }
        }
    }

    @Override
    public void deposit(double deposit) {
        Scanner scanner = new Scanner(System.in);
        if (negativeBalance > 0) {
            System.out.println("Do you wish to utilize this amount to offset your negative balance? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                double negativeBalance = getNegativeBalance();
                if (negativeBalance - deposit < 0) {
                    double difference = Math.abs(negativeBalance - deposit);
                    balance += difference;
                    setNegativeBalance(0);
                    System.out.println("Deposit successful." +
                            "\n New negative balance: " + getNegativeBalance() +
                            "\n New positive balance: " + getBalance());
                } else {
                    setNegativeBalance(deposit - balance);
                    System.out.println("Deposit successful. New negative balance: " + getBalance());
                }
            }
        } else {
            double positiveBalance = getBalance();
            setbalance(positiveBalance + deposit);
            System.out.println("Deposit successful. New positive balance: " + getBalance());
        }
    }


    @Override
    public String toString() {
        return "CheckingAccount{" +
                "\nAccount Negative Balance: " + negativeBalance +
                "\nAccount Positive Balance: " + balance +
                "\nAccount Total Balance: " + getTotalBalance() +
                "} " + super.toString();
    }

    public double getNegativeBalance() {
        return negativeBalance;
    }

    public void setNegativeBalance(double negativeBalance) {

        this.negativeBalance = negativeBalance;
    }

    public double getTotalBalance() {
        return balance - negativeBalance;
    }
}
