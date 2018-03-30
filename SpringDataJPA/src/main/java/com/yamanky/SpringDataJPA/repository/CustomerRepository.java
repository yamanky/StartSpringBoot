package com.yamanky.SpringDataJPA.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yamanky.SpringDataJPA.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	public List<Customer> findByOrderByFirstName();
	
}
