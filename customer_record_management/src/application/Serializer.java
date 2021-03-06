package application;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Serializer {
	private static final String Sales = "Sales.xml";
	static ArrayList<Sales> salesList =  new ArrayList<Sales>();
	private static Serializer instance= new Serializer();
	
	public static Serializer getInstance() {
			return instance;
		}
	@SuppressWarnings("unchecked")
	public static ArrayList<Sales> loadSales() {
		XMLDecoder decoder = null;

		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(Sales)));
			System.out.println("File stream opened and XMLDecoder created");

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Customer.xml not found");
		}

		salesList = (ArrayList<application.Sales>) decoder.readObject();
		decoder.close();

		return salesList;
	}
	
	public static void saveSales(ArrayList<Sales> salesList) {
		XMLEncoder encoder = null;

		try {

			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(Sales)));
			System.out.println("File stream written and XMLEncoder created");
		} catch (FileNotFoundException fileNotFound) {

		}

		encoder.writeObject(salesList);
		encoder.flush();
		encoder.close();
	}
}
