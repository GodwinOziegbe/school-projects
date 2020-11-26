package uppgift2_1;

public class Hund {
	String name;
	String race;
	
public Hund(String dogs_name, String dogs_race) {
	name = dogs_name;
	race = dogs_race;
	
	}
	


	public static void main(String[] args) {
		Hund minHund = new Hund("vannie", "German shepherd");
		System.out.println("My dogs name is: "+minHund.name+ "\nThe race is: "+ minHund.race);
		
	}

}
