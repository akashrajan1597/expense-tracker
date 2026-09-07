package com.akash.expense_tracker.repository;

import com.akash.expense_tracker.entity.Category;
import com.akash.expense_tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query("""
                    SELECT e FROM Expense e
                    WHERE (:category IS NULL OR e.category = :category)
                    AND (:from IS NULL OR e.date >= :from)
                    AND (:to IS NULL OR e.date <= :to)
                    AND (:minAmount IS NULL OR e.amount >= :minAmount)
                    AND (:maxAmount IS NULL OR e.amount <= :maxAmount)
            """)
    List<Expense> findExpesesWithFilters(
            @Param("category") Category category,
            @Param("from") LocalDate from,
            @Param("to") LocalDate to,
            @Param("minAmount") BigDecimal minAmount,
            @Param("maxAmount") BigDecimal maxAmount);
}
