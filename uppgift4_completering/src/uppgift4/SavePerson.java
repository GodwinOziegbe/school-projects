package uppgift4;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;



public class SavePerson {
	private static final String Person = "Person.xml";
	
	public void savePersonData(ArrayList<Person> personList) {
		XMLEncoder encoder = null;

		try {

			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(Person)));
			System.out.println("File stream opened and XMLEncoder created");

		} catch (FileNotFoundException fileNotFound) {
			System.out.println("ERROR: While Creating or Opening the File Person.xml");
		}

		encoder.writeObject(personList);
		System.out.println("Object written");
		encoder.flush();
		encoder.close();
		System.out.println("File stream closed");
	}	
	
	
}
