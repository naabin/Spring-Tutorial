package com.web.springdemo.dao;

import java.util.List;

import com.web.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String query);
}
