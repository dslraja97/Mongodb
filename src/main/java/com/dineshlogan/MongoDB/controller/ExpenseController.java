package com.dineshlogan.MongoDB.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dineshlogan.MongoDB.model.Expense;
import com.dineshlogan.MongoDB.service.ExpenceService;

@RestController
@RequestMapping("api/expense")
public class ExpenseController {
	private ExpenceService expenceService;

	public ExpenseController(ExpenceService expenceService) {
		this.expenceService = expenceService;
	}

	@PostMapping
	public ResponseEntity add(@RequestBody Expense expense) {
		expenceService.add(expense);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable String id) {
		expenceService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping
	public ResponseEntity update(@RequestBody Expense expense) {
		expenceService.update(expense);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{name}")
	public ResponseEntity findByName(@PathVariable String name) {
		return ResponseEntity.ok(expenceService.findByName(name));
	}

	@GetMapping()
	public ResponseEntity getAllExpence() {
		return ResponseEntity.ok(expenceService.getAllExpence());
	}

}
