package landskidstavling;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Serializer {
	private static final String Skiers = "Skiers.xml";
	static ArrayList<Skiers> skierList =  new ArrayList<Skiers>();

	public static ArrayList<Skiers> loadSkiers() {
		XMLDecoder decoder = null;

		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(Skiers)));
			System.out.println("File stream opened and XMLDecoder created");

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Skiers.xml not found");
		}

		skierList = (ArrayList<Skiers>) decoder.readObject();
		decoder.close();

		return skierList;
	}
	
	public static void saveSkiers(ArrayList<Skiers> skierList) {
		XMLEncoder encoder = null;

		try {

			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(Skiers)));

		} catch (FileNotFoundException fileNotFound) {

		}

		encoder.writeObject(skierList);
		encoder.flush();
		encoder.close();
	}

}
