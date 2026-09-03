package com.akash.expense_tracker.repository;

import com.akash.expense_tracker.entity.Category;
import com.akash.expense_tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDate;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory(Category category);

    List<Expense> findByDateBetween(LocalDate from, LocalDate to);
}
