package com.yamanky.SpringDataJPA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yamanky.SpringDataJPA.entity.Customer;
import com.yamanky.SpringDataJPA.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// 顧客全件取得
	@GetMapping
	public List<Customer> getCustomers() {
		List<Customer> customers = customerService.find();
		return customers;
	}

	// 個客一件取得
	@GetMapping(path = "{id}")
	public Optional<Customer> getCustomer(@PathVariable long id) {
		Optional<Customer> customer = customerService.findOne(id);
		return customer;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createCustomer(@RequestBody Customer customer) {
		customerService.create(customer);
	}

	@PutMapping(path = "{id}")
	public void updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
		customer.setId(id);
		customerService.update(customer);
	}

	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable long id) {
		customerService.delete(id);
	}
}
