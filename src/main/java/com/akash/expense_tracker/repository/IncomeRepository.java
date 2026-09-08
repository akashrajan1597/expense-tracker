package com.akash.expense_tracker.repository;

import com.akash.expense_tracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {

}
