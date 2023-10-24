package com.customers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customers.entity.Customer;
import com.customers.repository.CustomerRepository;
import com.customers.service.CustomerService;

/**
 * Service Implementation class to do CRUD operations
 * 
 * @author Balaji Krishna
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> retrieveAllCustomersInfo() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomerDetails(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer retrieveCustomerById(Long customerId) {
		return customerRepository.findById(customerId).get();
	}

	@Override
	public Customer updateCustomerInfo(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerInfoById(Long customerId) {
		customerRepository.deleteById(customerId);
	}

}
