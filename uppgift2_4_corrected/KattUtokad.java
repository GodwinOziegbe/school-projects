package uppgift2_4_corrected;

public class KattUtokad {
		private String owner;
		private String name;
		private int age;
		private String race;
		private String petsType;


		public KattUtokad(String owner, String name, int age, String race, String petsType) {
			this.owner= owner;
			this.name = name;
			this.age = age;
			this.race = race;
			this.petsType = petsType;
		}
		String getOwner(){
			return owner;
			
		}

		void setOwner(String owner){
			this.owner= name;
		}
		

		String getName(){
			return name;
			
		}

		void setName(String name){
			this.name= name;
		}


		int getAge() {
			return age;
		}

		void setAge(int age) {
			this.age= age;
		}
		String getRace(){
			return race;
		}
		void setRace(String race){
			this.race = race;
		}
		void setPet(String petsType){
			this.petsType = petsType;
		}

		String getPet(){
			return petsType;
		}

	
	
	

}
