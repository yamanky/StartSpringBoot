package com.yamanky.SpringDataJPA.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanky.SpringDataJPA.entity.Customer;
import com.yamanky.SpringDataJPA.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> find() {
		return customerRepository.findByOrderByFirstName();
	}

	public Optional<Customer> findOne(long customerId) {
		return customerRepository.findById(customerId);
	}

	public void create(Customer customer) {
		customerRepository.save(customer);
	}

	public void update(Customer customer) {
		customerRepository.save(customer);
	}

	public void delete(long customerId) {
		customerRepository.deleteById(customerId);
	}

}
