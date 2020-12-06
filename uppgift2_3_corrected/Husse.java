package uppgift2_3_corrected;

public class Husse {

	String owner;
	Dog dogList[];
		
	Husse(String name, Dog mydogList[]){
	this.owner= name;
	this.dogList= mydogList;
	
	}
	
	public static void main(String[] args) {
Dog[] dogList = new Dog[5];		
Husse husse = new Husse("Johan", dogList);

	dogList[0] = new Dog("Johan Magnus","    vannie",   12, "german shepherd");	
	dogList[1] = new Dog("Anna Harrison","   bonus ",    20, "poodle");
	dogList[2] = new Dog("Kalle Gustavsson","rosei ",    21, "Beagle");
	dogList[3] = new Dog("Johan Magnus   ","douglas",15,"Great Dane");
	dogList[4] = new Dog("Anna Harrison","  candle ",   13, "Bichon Frise");
	
	System.out.println("Below is the list of dogs, thier owners and other info:");
	System.out.println("Owner's Name        Dogs name    Age    Race");
	System.out.println("------------------------------------------------");
	for(int i=0; i<5; i++) {
	System.out.println( husse.dogList[i].owner +"       "+ husse.dogList[i].name  +"    "+
	husse.dogList[i].age  +"    "+ husse.dogList[i].race );		
		
	}
	
}
}
