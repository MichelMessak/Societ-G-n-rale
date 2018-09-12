package com.societe.exception;

/**
 * Exception thrown when bank account does not exist
 */
public class AccountNotExistException extends Exception {
    public AccountNotExistException(final String message) {
        super(message);
    }
}
