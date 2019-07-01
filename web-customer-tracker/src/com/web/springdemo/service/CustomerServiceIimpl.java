package com.web.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.springdemo.dao.CustomerDAO;
import com.web.springdemo.entity.Customer;

@Service
public class CustomerServiceIimpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

}
