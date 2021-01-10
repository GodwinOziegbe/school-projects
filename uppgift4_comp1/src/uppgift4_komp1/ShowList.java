package uppgift4_komp1;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ShowList {
	public ObservableList<Person> listOfPersons(){
		LoadPerson fileXML = new LoadPerson();
		ObservableList<Person> personList = 
		FXCollections.observableArrayList(fileXML.loadPersonData());
		
	
		return personList;
	
		
	}

}
