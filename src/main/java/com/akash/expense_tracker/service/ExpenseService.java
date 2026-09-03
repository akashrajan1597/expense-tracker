package com.akash.expense_tracker.service;

import com.akash.expense_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import com.akash.expense_tracker.entity.Category;
import com.akash.expense_tracker.dto.ExpenseRequest;
import com.akash.expense_tracker.entity.Expense;
import com.akash.expense_tracker.exception.ExpenseNotFoundException;
import com.akash.expense_tracker.exception.InvalidDateRangeException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpense(ExpenseRequest request) {
        Expense expense = new Expense();

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(request.getDescription());
        expense.setDate(request.getDate());

        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));
    }

    public List<Expense> getExpensesByCategory(Category category) {
        return expenseRepository.findByCategory(category);
    }

    public List<Expense> getExpensesByDateRange(LocalDate from, LocalDate to) {

        if (from.isAfter(to)) {
            throw new InvalidDateRangeException();
        }

        return expenseRepository.findByDateBetween(from, to);
    }

    public Expense updateExpense(Long id, ExpenseRequest request) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(request.getDescription());
        expense.setDate(request.getDate());

        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));

        expenseRepository.delete(expense);
    }
}
