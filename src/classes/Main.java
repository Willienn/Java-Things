package classes;


public class Main {
    public static void main(String[] args) {
        Account account1 = new CheckingAccount("Willien", "willienmuniz@hotmail.com", "64 992902445", 100);
        Account account2 = new SavingsAccount("Willien", "willienmuniz@hotmail.com", "64 992902445", 100);

        account1.deposit(300);

        account1.withdraw(800);
    }
}
