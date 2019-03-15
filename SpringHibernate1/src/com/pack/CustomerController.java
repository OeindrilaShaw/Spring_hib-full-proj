package com.pack;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.Service.CustomerService;
import com.pack.form.Customer;

@Controller
public class CustomerController {
private CustomerService customerService;
@Autowired(required=true)
@Qualifier(value="customerService") //if we gave different bean name in my xml and a diff in autowired that time to remove confusion we use this also onebean with same id
public void setCustomerService(CustomerService customerService) {
	this.customerService = customerService;
}
@RequestMapping("/index")
public String listCustomer(Map<String,Object> m){
	m.put("customer",new Customer());
	m.put("customerList",customerService.listCustomer());
	return "customer";
}
@RequestMapping(value="/customer/add", method=RequestMethod.POST)
public String addCustomer(@ModelAttribute("customer")Customer customer){
	if(null==customer.getId())
	{
		Random r=new Random();
		int num=r.nextInt(900000)+100000;
		customer.setId(num);
		customerService.addCustomer(customer);
		
	}
	else
	{
		customerService.updateCustomer(customer);
	}
	return "redirect:/index";
}
@RequestMapping("/edit/{cid}") //{} this used to change the id accordingly like 100,200..so on
public String editCustomer(@PathVariable("cid") Integer custid,Map<String,Object> m){
	Customer c=customerService.getCustomerById(custid);
	m.put("customer",c); //represents one customer object
	m.put("customerlist",customerService.listCustomer());
	return "customer";
}
@RequestMapping("/delete/{cid}")
public String deleteCustomer(@PathVariable("cid") Integer custid){
	customerService.removeCustomer(custid);
	return "redirect:/index";
}
}
