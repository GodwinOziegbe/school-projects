package uppgift4_komp1;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class LoadPerson {
	private static final String Person = "Person1.xml";
	
	ArrayList<Person> personList1;
	public ArrayList<Person> loadPersonData() {
		
		
	 XMLDecoder decoder = null;
		try {
			
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(Person)));
			System.out.println("File stream opened and XMLDecoder created");

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Person.xml not found");
		}

		
		personList1 = (ArrayList<Person>) decoder.readObject();
		decoder.close();

	 return personList1;
	    	 
	 		
	    	

	     }			 
	}
	
		
	

