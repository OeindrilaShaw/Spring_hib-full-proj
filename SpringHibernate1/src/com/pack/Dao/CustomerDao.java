package com.pack.Dao;

import java.util.List;

import com.pack.form.Customer;

public interface CustomerDao {
		public void addCustomer(Customer c);
		public void updateCustomer(Customer c);
		public Customer getCustomerById(Integer Customerid);
		public List<Customer> listCustomer();
		public void removeCustomer(Integer id);
}
