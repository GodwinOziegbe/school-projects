package uppgift4;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.application.Application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PersonHant extends Application {
	
	Scene scene;
	VBox vBox,vBox1;
	HBox hBox, hBox1, hBox2, hBox3;
	Text  fntext, lntext, agetext,text,fnametext,lnametext, agtext, fnheading,lnheading,agheading;
	Button updateButton, showListButton,addButton, delButton,sasButton, resetButton, clearButton, savelistButton, fnbutton;
	TextField addFname, addLname, addAge;
	boolean click = true, hit=true;
	String fn=null, ln=null, ag=null,del_fName=null,del_lName=null, del_age=null;
	
	private static final String SERIALIZED_FILE_NAME = "Person.xml"; 
	
	
	ArrayList<Person> personList = new ArrayList<Person>();
	ShowList show = new ShowList();
	
	private TableView<Person> table = new TableView<Person>();
    
    public static void main(String[] args) {
        launch(args);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage stage) {
      
    
 
        TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("First Name");
        
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
 
        TableColumn<Person, String> lastNameCol = new TableColumn<Person, String>("Last Name");
        
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
 
        TableColumn<Person, String> ageCol = new TableColumn<Person, String>("Age");
       
        ageCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("age"));
 
        firstNameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));
		lastNameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
		ageCol.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		
       table.getColumns().addAll(firstNameCol, lastNameCol, ageCol);
       ObservableList<Person> showlist=show.listOfPersons();
		 
		 for(Person value:showlist)
		   { 
		     
		    	table.getItems().add(value);
		     }
       
        addFname= new TextField();
		 addFname.setPromptText("First Name");
		 addLname= new TextField();
		 addLname.setPromptText("Last Name");
		 addAge= new TextField();
		 addAge.setPromptText("Age");
			
			fntext= new Text("First name:");
			lntext = new Text("Last name:");
			agetext = new Text("Age:          ");
		 fnametext=new Text("");
		lnametext=new Text("");
		agtext=new Text("");
		 fnheading = new Text("First Name");
		 lnheading = new Text("Last Name");
		 agheading = new Text("Age");
		
		updateButton = new Button("Update");
		addButton = new Button("Add");
		delButton = new Button("Delete");
		savelistButton= new Button("Save list");
		showListButton = new Button("Show List");
        fnbutton= new Button("name");
	
		 
		 savelistButton.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
	            public void handle(ActionEvent e) {
			
				 SavePerson saveper = new SavePerson();
					saveper.savePersonData(personList);
			 
			 }
			 }); 
			 
		 showListButton.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
	            public void handle(ActionEvent e) {
				 ObservableList<Person> showlist=show.listOfPersons();
				 table.getItems().clear();
				 
				 for(Person value:showlist)
				   { 
				     
				    	table.getItems().add(value);
				     }
			 }
			 }); 
			 
		 
		 addButton.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
	            public void handle(ActionEvent e) {
	                
				 String fName=addFname.getText();
				 String lName=addLname.getText();
				String myAge= addAge.getText().toString();
				
				 Person person = new Person();
				 person.setFirstName(fName);
				 person.setLastName(lName);
				 person.setAge(myAge);
				
				 personList.add(person);
				 
				
	               
	                		addFname.clear();
	                		addLname.clear();
	                		addAge.clear();
	                		
	                		
	            }
			
		 });
		
		 delButton.setOnAction(new EventHandler<ActionEvent>() {
			 DeletePerson delete = new DeletePerson();
			 
			 @SuppressWarnings("static-access")
			@Override
	            public void handle(ActionEvent e) {
				 ObservableList<Person> showlist=show.listOfPersons();
				    Person selectedItem = table.getSelectionModel().getSelectedItem();
				    del_fName = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getFirstName();
				     del_lName = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getLastName();
				     del_age = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getAge();
				     
				    
				         
				     
				     for(Person value: showlist) {
				    	 if (value.getFirstName().contentEquals(del_fName) &&value.getLastName().contentEquals(del_lName) && 
				    			 value.getAge().contentEquals(del_age))
				    	 {
				    		 
				    		 
									delete.del(del_fName);
								
				    		
				    		 SavePerson save = new SavePerson();
								save.savePersonData(personList);
								
								 
								
				    		break; 
				    	 }
				    	  
				     }
				    
				    table.getItems().remove(selectedItem);
				   
			 }
				});
			
		updateButton.setOnAction(new EventHandler<ActionEvent>() {
			
			 @Override
	            public void handle(ActionEvent e) {
				 
					 if(click) { 
				   Person selectedItem = table.getSelectionModel().getSelectedItem();
				    fn = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getFirstName();
				     ln = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getLastName();
				     ag = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getAge();
				   
					     addFname.setText(fn);
					     addLname.setText(ln);
					     addAge.setText(ag);
					     
					     table.getItems().remove(selectedItem);  
					     click= false;
				 
				    
				  }
				    	
					     else {
					    	 Person person = new Person();
					     
				    	
				    	 person.setFirstName(fn);
				    	 person.setFirstName(ln);
				    	 person.setFirstName(ag);
				    	 
				    	 personList.add(person);
			             
				    	 		addFname.clear();
				    	 		addLname.clear();
				    	 		addAge.clear();
				    	 		
				    	 		SavePerson save= new SavePerson();
						 		save.savePersonData(personList);
						 		
						 		
		    					click = true;
		    					
		    					}
				    	 		
				     }
			   		
				
			 
				});	  
		
		
		hBox = new HBox(20);
		
		hBox.setAlignment(Pos.TOP_RIGHT);
		hBox.getChildren().addAll(showListButton,savelistButton, updateButton, addButton, delButton);

		hBox1 = new HBox(350);
		hBox2 = new HBox(350);
		hBox3 = new HBox(350);
		
		hBox1.getChildren().addAll(fntext, addFname);
		hBox2.getChildren().addAll(lntext, addLname);
		hBox3.getChildren().addAll(agetext,     addAge);
		
		vBox = new VBox(10);
	    vBox.setAlignment(Pos.TOP_LEFT);
	    
	   
		 vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox, table);
		 
		scene = new Scene(vBox,  560, 500); 
		stage.setScene(scene);
        stage.setTitle("Personhanterare");
		stage.show();
        
        
       
    }

   
	
}


