package com.web.springdemo.service;

import java.util.List;

import com.web.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String query);
}
