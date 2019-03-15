package com.pack.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.Dao.CustomerDao;
import com.pack.form.Customer;
@Service /*to mean its a sErvice impl*/
public class CustomerServiceImpl implements CustomerService {
private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
	this.customerDao = customerDao;
}

	
	@Transactional
	public void addCustomer(Customer c) {
		customerDao.addCustomer(c);

	}

	
	@Transactional
	public void updateCustomer(Customer c) {
		customerDao.updateCustomer(c);

	}

	
	@Transactional
	public Customer getCustomerById(Integer Customerid) {
		
		return customerDao.getCustomerById(Customerid);
	}

	
	@Transactional
	public List<Customer> listCustomer() {
		List<Customer> l=customerDao.listCustomer();
		return l;
	}

	
	@Transactional
	public void removeCustomer(Integer id) {
		// TODO Auto-generated method stub
      customerDao.removeCustomer(id);
	}

}
