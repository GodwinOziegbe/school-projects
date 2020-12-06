package uppgift2_2_corrected;

public class Katt {
private String name;
private int age;
private String race;
private String petsType;


public Katt(String name, int age, String race, String petsType) {
	this.name = name;
	this.age = age;
	this.race = race;
	this.petsType = petsType;
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