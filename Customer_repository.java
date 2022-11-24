package com.BATCH.Spring_batch.REPOSITORY;

import com.BATCH.Spring_batch.ENTITY.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer_repository extends JpaRepository<Customer, Integer> {
}
