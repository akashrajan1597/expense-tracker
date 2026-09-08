package com.akash.expense_tracker.service;

import com.akash.expense_tracker.entity.Income;
import com.akash.expense_tracker.repository.IncomeRepository;
import org.springframework.stereotype.Service;
import com.akash.expense_tracker.dto.IncomeRequest;
import com.akash.expense_tracker.exception.IncomeNotFoundException;

import java.util.List;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Income createIncome(IncomeRequest request) {

        Income income = new Income();
        income.setTitle(request.getTitle());
        income.setAmount(request.getAmount());
        income.setSource(request.getSource());
        income.setDescription(request.getDescription());
        income.setDate(request.getDate());

        return incomeRepository.save(income);
    }

    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }

    public Income updateIncome(Long id, IncomeRequest request) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new IncomeNotFoundException(id));

        income.setTitle(request.getTitle());
        income.setAmount(request.getAmount());
        income.setSource(request.getSource());
        income.setDescription(request.getDescription());
        income.setDate(request.getDate());

        return incomeRepository.save(income);
    }

    public void deleteIncome(Long id) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new IncomeNotFoundException(id));

        incomeRepository.delete(income);
    }
}
