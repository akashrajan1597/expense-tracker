package com.akash.expense_tracker.exception;

public class IncomeNotFoundException extends RuntimeException {
    public IncomeNotFoundException(Long id) {
        super("Income not found with id: " + id);
    }

}
