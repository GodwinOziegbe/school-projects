package uppgift2_3;

public class Husse {
	
	String mastersName;
	Integer dogID;
	Integer numDogsOwned;
	String dogsName;
	Integer dogsAge;
	
	
	Husse(String owner, Integer dogNum, String nameOfdog, Integer ageOfDog){
		this.mastersName= owner;
		this.dogID= dogNum;
		this.dogsName= nameOfdog;
		this.dogsAge= ageOfDog;
		
	}
	Husse(String owner, Husse hund){
		this.mastersName= hund.mastersName;
		this.dogID= hund.dogID;
		this.dogsName= hund.dogsName;
		this.dogsAge= hund.dogsAge;
	}
	
	
	public static void main(String[] args) {
		Husse husse1 = new Husse("Kalle",101,"bingo", 5);
		Husse hund1 = new Husse("Kalle",husse1);
		
		Husse husse2 = new Husse("Kalle",102,"skippy", 3);
		Husse hund2 = new Husse("Kalle",husse2);
		
		Husse husse3 = new Husse("Kalle",103,"bonus", 2);
		Husse hund3 = new Husse("Kalle",husse3);
		
		
		System.out.println("Owners name: "+ husse1.mastersName+"\n------------------------");
		System.out.println("\n"+husse1.mastersName+ " has following dogs:");
		
		System.out.println("Dog's ID: "+ hund1.dogID
		 + "\nDogs name: "+ hund1.dogsName
		 + "\ndogs age: "+hund1.dogsAge+" years"
		 );
		 
		 System.out.println("\nDog's ID: "+ hund2.dogID
				 + "\nDogs name: "+ hund2.dogsName
				 + "\ndogs age: "+hund2.dogsAge+" years"
		 );
		 
		 System.out.println("\nDog's ID: "+ hund3.dogID
				 + "\nDogs name: "+ hund3.dogsName
				 + "\ndogs age: "+hund3.dogsAge+" years"
				 
		);
	}

}
