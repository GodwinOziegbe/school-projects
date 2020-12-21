package application;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;




public class SaveCustomers {

	private static final String Customer = "Customer.xml";
	//Customer customerList1;

	public void saveCustomerData(ArrayList<Customer> customerList) {
		XMLEncoder encoder = null;

		try {

			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(Customer)));
			System.out.println("File stream opened and XMLEncoder created");

		} catch (FileNotFoundException fileNotFound) {
			System.out.println("ERROR: While Creating or Opening the File Customer.xml");
		}

		encoder.writeObject(customerList);
		System.out.println("Object written");
		encoder.flush();
		encoder.close();
		System.out.println("File stream closed");
	}	
	
}
