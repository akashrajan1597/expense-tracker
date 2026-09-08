package com.akash.expense_tracker.controller;

import com.akash.expense_tracker.entity.Income;
import com.akash.expense_tracker.service.IncomeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.akash.expense_tracker.dto.IncomeRequest;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Income createIncome(@Valid @RequestBody IncomeRequest request) {
        return incomeService.createIncome(request);
    }

    @GetMapping
    public List<Income> getAllIncome() {
        return incomeService.getAllIncome();
    }

    @PutMapping("/{id}")
    public Income updateIncome(
            @PathVariable Long id,
            @Valid @RequestBody IncomeRequest request) {

        return incomeService.updateIncome(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
    }
}
