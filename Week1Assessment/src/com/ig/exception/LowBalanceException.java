package com.ig.exception;

public class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}
