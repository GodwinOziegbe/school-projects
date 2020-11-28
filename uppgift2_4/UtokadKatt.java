package uppgift2_4;

public class UtokadKatt {
	String name;
	String race;
	String owner;

	public UtokadKatt(String cats_name, String cats_race, String cat_owner) {
		
		name= cats_name;
		race= cats_race;
		owner= cat_owner;
	}

	public static void main(String[] args) {
		UtokadKatt katt = new UtokadKatt("kittie", "persian cat", "Jenny" );
		System.out.println("My cat's name is: "+ katt.name+ 
				"\nThe race is: "+katt.race+ "\n the owner's name is: "+
				katt.owner);
		
	}
	}

	


