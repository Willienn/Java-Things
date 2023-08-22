package classes.acount;

import classes.acount.Account;

public class SavingsAccount extends Account {

    public SavingsAccount(String owner, String email, String phoneNumber, double initialBalance) {
        super(owner, email, phoneNumber, "savings", initialBalance);
    }

}
