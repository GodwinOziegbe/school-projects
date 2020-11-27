package uppgift2_2;

public class Matte {
	
	String name;
	
	String pets_name;
	String pet;
	public Matte(String owners_name, String pets_type, String mypets_name) {
		name= owners_name;
		pet= pets_type;
		pets_name= mypets_name;
	}
	Matte(String owners_name, Matte katt){
		this.name= owners_name;
		this.pet= katt.pet;
		this.pets_name= katt.pets_name;
		
	}
	
	public static void main(String[] args) {
		Matte myMatt= new Matte("Bobby", "A cat", "Kittie");
		Matte myKatt = new Matte("Bobby", myMatt );
		
		
	System.out.println("The name of the owner is: "+ myKatt.name+"\nThe owner's pet is a "+ myKatt.pet
			+ "\nThe name of the pet is "+ myKatt.pets_name);	
				
	}
	
    }
    
