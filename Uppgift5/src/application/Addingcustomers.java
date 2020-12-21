package application;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;

public class Addingcustomers {
	private static final String Customer = "Customer.xml";		
	
	public void  createAccount(String acct, String mypass) {
	
		Double acct_bal= 0.0;
		String open_date= myDate();
		String lat_trans= "none";
		
		Customer customer = new Customer();
		
		customer.setAccountNumber(acct);
		customer.setPassword(mypass);
		customer.setAccountBalance(acct_bal);
		customer.setOpeningDate(open_date);
		customer.setLatestTransaction(lat_trans);
		
		
			XMLEncoder encoder = null;

			try {

				encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(Customer)));
				System.out.println("File stream opened and XMLEncoder created");

			} catch (FileNotFoundException fileNotFound) {
				System.out.println("ERROR: While Creating or Opening the File Customer.xml");
			}

			encoder.writeObject(customer);
			System.out.println("Object written");
			encoder.flush();
			encoder.close();
			System.out.println("File stream closed");
		}	
		
		
		
	

	String myDate() {// function to generate date time
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateString = format.format(new Date());

		return dateString;

	}
}
