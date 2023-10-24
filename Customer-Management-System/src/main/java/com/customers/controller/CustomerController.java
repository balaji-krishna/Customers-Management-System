package com.customers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customers.entity.Customer;
import com.customers.service.CustomerService;

/**
 * Controller class to do CRUD operations
 * 
 * @author Balaji Krishna
 */
@Controller
@RequestMapping(path = "cstms")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * handler method to retrieve list of customers
	 * 
	 * @param model
	 * @return customers_model view
	 */
	@GetMapping("retrieveAllCustomersInfo")
	public String retrieveAllCustomersInfo(Model model) {
		model.addAttribute("customersInfo", customerService.retrieveAllCustomersInfo());
		return "customers_model";
	}

	/**
	 * handler method to create a new customer
	 * 
	 * @param model
	 * @return customers_details_form view
	 */
	@GetMapping("customersDetailsForm")
	public String customersDetailsForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customerDetails", customer);
		return "customers_details_form";
	}

	/**
	 * method to save customer details
	 * 
	 * @param customer
	 * @return customers_model view
	 */
	@PostMapping("saveCustomerDetails")
	public String saveCustomerDetails(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomerDetails(customer);
		return "redirect:/cstms/retrieveAllCustomersInfo";
	}

	/**
	 * handler method to edit a customer
	 * 
	 * @param customerId
	 * @param model
	 * @return edit_customers_form view
	 */
	@GetMapping("editCustomersInfo/{customerId}")
	public String editCustomersInfo(@PathVariable Long customerId, Model model) {
		model.addAttribute("customer", customerService.retrieveCustomerById(customerId));
		return "edit_customers_form";
	}

	/**
	 * method to update customer info
	 * 
	 * @param customerId
	 * @param updateCustomer
	 * @return customers_model view
	 */
	@PostMapping("updateCustomerInfo/{customerId}")
	public String updateCustomerInfo(@PathVariable Long customerId,
			@ModelAttribute("customer") Customer updateCustomer) {
		Customer existingCustomer = customerService.retrieveCustomerById(customerId);
		existingCustomer.setCustomerId(customerId);
		existingCustomer.setCustomerFirstName(updateCustomer.getCustomerFirstName());
		existingCustomer.setCustomerLastName(updateCustomer.getCustomerLastName());
		existingCustomer.setCustomerEmail(updateCustomer.getCustomerEmail());
		customerService.updateCustomerInfo(existingCustomer);
		return "redirect:/cstms/retrieveAllCustomersInfo";
	}

	/**
	 * handler method to delete a customer by customerId
	 * 
	 * @param customerId
	 * @return customers_model view
	 */
	@GetMapping("deleteCustomerInfoById/{customerId}")
	public String deleteCustomerInfoById(@PathVariable Long customerId) {
		customerService.deleteCustomerInfoById(customerId);
		return "redirect:/cstms/retrieveAllCustomersInfo";
	}

}
