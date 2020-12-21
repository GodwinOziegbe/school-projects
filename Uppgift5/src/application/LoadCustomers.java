package application;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LoadCustomers {
	private static final String Customer = "Customer.xml";
	ArrayList<Customer> customerList3;

	@SuppressWarnings("unchecked")
	public ArrayList<application.Customer> ListCustomers(ArrayList<Customer> customerList3) {
		XMLDecoder decoder = null;

		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(Customer)));
			System.out.println("File stream opened and XMLDecoder created");

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Customer.xml not found");
		}

		customerList3 = (ArrayList<Customer>) decoder.readObject();
		decoder.close();

		return customerList3;//return to main
	}

}
