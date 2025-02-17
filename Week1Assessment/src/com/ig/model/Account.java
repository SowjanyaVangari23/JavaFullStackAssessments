package com.ig.model;

import com.ig.exception.InvalidAmountException;
import com.ig.exception.LowBalanceException;

public class Account {

	    Integer accNumber;
	    String custName;
	    AccountType type; // Use enum for account type
	    Float balance;

	    // Constructor to initialize the account
	    public Account(Integer accNumber, String custName, AccountType type, Float balance) throws InvalidAmountException, LowBalanceException {
	        if (balance < 0) {
	            throw new InvalidAmountException("Initial balance cannot be negative");
	        }
	        this.accNumber = accNumber;
	        this.custName = custName;
	        this.type = type;
	        this.balance = balance;

	        if ((type == AccountType.SAVINGS && balance < 1000) || (type == AccountType.CURRENT && balance < 5000)) {
	            throw new LowBalanceException("Balance is too low for the account type");
	        }
	    }

	    public Integer getAccNumber() {
	        return accNumber;
	    }

	    public String getCustName() {
	        return custName;
	    }

	    public AccountType getType() {
	        return type;
	    }

	    public Float getBalance() {
	        return balance;
	    }

	    public void setBalance(Float balance) {
	        this.balance = balance;
	    }
}


