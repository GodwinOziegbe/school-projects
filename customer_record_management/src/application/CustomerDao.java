package application;

import java.util.ArrayList;

public class CustomerDao {
	private ArrayList <Customer> customerList = new ArrayList<Customer>();
	private static CustomerDao instance=new CustomerDao();
	public CustomerDao() {
	}
	public static CustomerDao getInstance() {
		return instance;
	}
	
		public Customer getCustomer(String customerId) {
			Customer currentCustomer=null;
			for (Customer value: customerList) {
			if (value.getId()==customerId) {
					currentCustomer= value;
					break;
			}
		}
			return currentCustomer;
			
		}
		public void saveCustomer(Customer customer) {
			customerList.add(customer);
			
		}
		
		
		public void updateCustomer(Customer currentCustomer, Customer customer) {
			//Todo
			customerList.add(customer);
		}
		
		public void deleteCustomer(Customer customer) {
			customerList.remove(customer);
		}
	

}