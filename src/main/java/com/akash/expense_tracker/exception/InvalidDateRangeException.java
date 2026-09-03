package com.akash.expense_tracker.exception;

public class InvalidDateRangeException extends RuntimeException {
    public InvalidDateRangeException() {
        super("From date cannot be after to date");
    }
}
