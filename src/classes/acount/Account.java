package classes.acount;

public class Account {
    protected final int number = (int) (Math.random() * 900000) + 100000;
    protected double balance;
    protected String type;
    private String owner;
    private String email;
    private String phoneNumber;

    public Account() {
    }

    public Account(String owner, String email, String phoneNumber, String type, double balance) {
        this.owner = owner;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void withdraw(double amount) {
        double positiveBalance = getBalance();

        if (positiveBalance - amount >= 0) {
            setbalance(positiveBalance - amount);
            double newPositiveBalance = getBalance();
            System.out.println("Withdrawal successful. New balance is: " + newPositiveBalance);
        } else {
            System.out.println("Withdrawal failed. Can't overdraw with acount type of '" + getType() + "'");

        }

    }

    public void deposit(double deposit) {
        setbalance(balance += deposit);
        System.out.println("Deposit successful. New positive balance: " + getBalance());
    }

    @Override
    public String toString() {
        return "Account Id: " + number +
                "\nAccount Owner: " + owner +
                "\nAccount Email: " + email +
                "\nAccount Phone Number: " + phoneNumber;
    }


    public int getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setbalance(double positiveBalance) {
        this.balance = positiveBalance;
    }

}
