package com.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customers.entity.Customer;

/**
 * Repository interface that extends JpaRepository
 * 
 * @author Balaji Krishna
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
