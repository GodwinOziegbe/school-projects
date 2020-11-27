package uppgift2_2;

public class Matte2 {
	
	String name;
	String pet;
	String pets_name;
	public Matte2(String owners_name, Pet katt) {
		this.name= owners_name;
		this.pet= katt.pets_name;
		this.pets_name= katt.pets_name;
	
	}

	public class Pet{
    	String owners_name;
		String pets_type;
    	String pets_name;
    	
    
	Pet(String owner, String pet, String pname){
	this.owners_name=owner;
	this.pets_type= pet;
	this.pets_name= pname;
	}
	}
	public static void main(String[] args) {
		
	/*	Matte2 myMatt = new Matte2("Bobby", mypet );
		Matte2.Pet mypet =  myMatt.new Pet("Bobby", "a cat", "kittie");
		
	System.out.println("The name of the owner is: "+ myMatt.name+"\nThe owner's pet is a "+ mypet.pets_type
			+ "\nThe name of the pet is "+ mypet.pets_name);	
		*/		
	}
	
    }
    
