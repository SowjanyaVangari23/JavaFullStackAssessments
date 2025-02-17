package com.ig.service;

import java.util.ArrayList;
import java.util.List;

import com.ig.exception.AccountNotFoundException;
import com.ig.exception.InsufficientFundsException;
import com.ig.exception.InvalidAmountException;
import com.ig.model.Account;
import com.ig.model.AccountType;

public class AccountService {

	    public List<Account> accountList = new ArrayList<>();

	    // Check if account is valid (existing account number)
	    public boolean isValidAccount(int accNumber) throws AccountNotFoundException {
	        for (Account account : accountList) {
	            if (account.getAccNumber() == accNumber) {
	                return true;
	            }
	        }
	        throw new AccountNotFoundException("Account number not found");
	    }

	    // Deposit amount into account
	    public void deposit(int accNumber, float amt) throws InvalidAmountException, AccountNotFoundException {
	        if (amt < 0) {
	            throw new InvalidAmountException("Deposit amount cannot be negative");
	        }

	        Account account = findAccountByNumber(accNumber);
	        account.setBalance(account.getBalance() + amt);
	    }

	    // Withdraw amount from account
	    public void withdraw(int accNumber, float amt) throws InvalidAmountException, InsufficientFundsException, AccountNotFoundException {
	        if (amt < 500) {
	            throw new InvalidAmountException("Withdrawal amount should be at least 500");
	        }

	        Account account = findAccountByNumber(accNumber);
	        if (account.getType() == AccountType.SAVINGS && account.getBalance() - amt < 1000) {
	            throw new InsufficientFundsException("Insufficient funds in Savings account");
	        }
	        if (account.getType() == AccountType.CURRENT && account.getBalance() - amt < 5000) {
	            throw new InsufficientFundsException("Insufficient funds in Current account");
	        }

	        account.setBalance(account.getBalance() - amt);
	    }

	    // Get balance of the account
	    public float getBalance(int accNumber) throws AccountNotFoundException {
	        Account account = findAccountByNumber(accNumber);
	        return account.getBalance();
	    }

	    // Helper method to find account by number
	    private Account findAccountByNumber(int accNumber) throws AccountNotFoundException {
	        for (Account account : accountList) {
	            if (account.getAccNumber() == accNumber) {
	                return account;
	            }
	        }
	        throw new AccountNotFoundException("Account number not found");
	    }



}
