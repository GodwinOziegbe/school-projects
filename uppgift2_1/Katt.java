package uppgift2_1;

public class Katt {
String name;
String race;

public Katt(String cats_name, String cats_race) {
	
	name= cats_name;
	race= cats_race;
}

public static void main(String[] args) {
	Katt minKatt = new Katt("kittie", "persian cat" );
	System.out.println("My cat's name is: "+ minKatt.name+ "\nThe race is: "+minKatt.race);
	
}
}
