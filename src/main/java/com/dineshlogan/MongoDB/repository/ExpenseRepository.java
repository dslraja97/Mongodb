package com.dineshlogan.MongoDB.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.dineshlogan.MongoDB.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
	@Query("'name':?0")
	Optional<Expense> findByName(String name);
}
