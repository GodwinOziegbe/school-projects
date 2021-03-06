package application;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LoggingIn {
	private static final String Customer = "Customer.xml";
	ArrayList<Customer> customerList2;
	

	@SuppressWarnings("unchecked")
	public ArrayList<Customer> VerifyCustomer(String acct1, String pass1) {
		XMLDecoder decoder = null;

		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(Customer)));
			System.out.println("File stream opened and XMLDecoder created");

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Customer.xml not found");
		}

		customerList2 = (ArrayList<Customer>) decoder.readObject();
		decoder.close();

		
		return customerList2;
}
}