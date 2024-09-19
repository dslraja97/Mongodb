package com.dineshlogan.MongoDB.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dineshlogan.MongoDB.model.Expense;
import com.dineshlogan.MongoDB.repository.ExpenseRepository;

@Service
public class ExpenceService {
	private final ExpenseRepository expenseRepository;

	public ExpenceService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public void add(Expense expense) {
		expenseRepository.insert(expense);
	}

	public void delete(String id) {
		expenseRepository.deleteById(id);
	}

	public void update(Expense expense) {
		Expense saveExpense = expenseRepository.findById(expense.getId())
				.orElseThrow(() -> new RuntimeException(String.format("Can't find the Expense byID Field %s", expense.getId())));
		saveExpense.setExpenseName(expense.getExpenseName());
		saveExpense.setExpenseCategory(expense.getExpenseCategory());
		saveExpense.setPrice(expense.getPrice());

		expenseRepository.save(saveExpense);
	}

	public Expense findByName(String name) {
		return expenseRepository.findByName(name)
				.orElseThrow(() -> new RuntimeException(String.format("Can't find the Expense by name Field %s", name)));
	}

	public List<Expense> getAllExpence() {
		return expenseRepository.findAll();
	}
}
