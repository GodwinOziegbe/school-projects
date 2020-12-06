package uppgift2_1_corrected;

public class Husdjur {
	private String type;
	private int age;

	String getType(){
		return type;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age= age;
	}
	void setType(String type){
		this.type= type;
	}
}
	
	class Hund extends Husdjur{
	private String name;
	 private String race;

	String getName(){
		return name;
		
	}

	void setName(String name){
		this.name= name;
	}

	String getRace(){
		return race;
	}

	void setRace(String race){
		this.race = race;
	}
	
	}
	
	class Katt extends Husdjur{
		private String name;
		private String race;
		String getName(){
			return name;
			
		}

		void setName(String name){
			this.name= name;
		}

		String getRace(){
			return race;
		}

		void setRace(String race){
			this.race = race;
		}
	
	public static void main(String[] args) {
		
		
		
		Hund hund = new Hund();
		Katt katt = new Katt();
		hund.setType("Dog");
		hund.setAge(2);
		hund.setName("vannie");
		hund.setRace("German shepherd");
		
		System.out.println("Pet number one");
		System.out.println("---------------");
		
		System.out.println("My first pet is a: "+ hund.getType() + "\nThe age is: "+ hund.getAge()+" years old");
		System.out.println("her name is: "+ hund.getName() + "\nThe race is: "+ hund.getRace());
		
	
		katt.setAge(3);
		katt.setType("Cat");
		katt.setName("kittie");
		katt.setRace("persian cat");
		
		System.out.println("-------------------------------\n");
		System.out.println("Pet number two");
		System.out.println("---------------");
		
		System.out.println("My second pet is a: "+ katt.getType() + "\nThe age is: "+ katt.getAge()+" years old");
		System.out.println("My Cat's name is: "+ katt.getName() + "\nThe race is: "+ katt.getRace());
	}
	
	}
	
		

	


