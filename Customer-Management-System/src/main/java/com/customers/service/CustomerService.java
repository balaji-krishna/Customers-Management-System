package com.customers.service;

import java.util.List;

import com.customers.entity.Customer;

/**
 * Service Interface to do CRUD operations
 * 
 * @author Balaji Krishna
 */
public interface CustomerService {

	List<Customer> retrieveAllCustomersInfo();

	Customer saveCustomerDetails(Customer customer);

	Customer retrieveCustomerById(Long customerId);

	Customer updateCustomerInfo(Customer customer);

	void deleteCustomerInfoById(Long customerId);

}
