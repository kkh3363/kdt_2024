package myapp.service;
import java.util.HashMap;
import java.util.Map;

import myapp.model.*;

public class CustomerService {
	private Map<String, Customer> customers;
	
	public CustomerService() {
		customers = new HashMap<String, Customer>();
		
		addCustomer(new Customer("d001","Alice", "alice.snut.ac.kr"));
		addCustomer(new Customer("d002","Bob", "bob.snut.ac.kr"));
		addCustomer(new Customer("d004","Charlie", "chrlie.snut.ac.kr"));
	}
	
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}
	
	public Customer findCustomer(String id) {
		if ( id != null)
		{
			System.out.println(id);
			return customers.get(id.toLowerCase());
		}
		else
			return null;
	}
}
