package com.ig.ui;

import com.ig.exception.*;
import com.ig.model.Account;
import com.ig.model.AccountType;
import com.ig.service.AccountService;

public class AccountTest {

    public static void main(String[] args) {
        try {
            AccountService accountService = new AccountService();

            // Creating accounts
            Account acc1 = new Account(1001, "John Doe", AccountType.SAVINGS, 1500f);
            Account acc2 = new Account(1002, "Jane Doe", AccountType.CURRENT, 6000f);

            // Adding accounts to the service
            accountService.accountList.add(acc1);
            accountService.accountList.add(acc2);

            // Checking account balance
            System.out.println("Balance of account 1001: " + accountService.getBalance(1001));

            // Depositing money
            accountService.deposit(1001, 500f);
            System.out.println("Balance of account 1001 after deposit: " + accountService.getBalance(1001));

            // Withdrawing money
            accountService.withdraw(1001, 700f);
            System.out.println("Balance of account 1001 after withdrawal: " + accountService.getBalance(1001));

        } catch (AccountNotFoundException | InvalidAmountException | InsufficientFundsException | LowBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

