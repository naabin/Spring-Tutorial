package com.web.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.springdemo.entity.Customer;
import com.web.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//inject the dao customer dao
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from the dao
		List<Customer> customers = customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers", customers);
		return "list-customers";
	}
}
