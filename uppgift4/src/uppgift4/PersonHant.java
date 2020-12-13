package uppgift4;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
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
	VBox vBox;
	HBox hBox, hBox1, hBox2, hBox3, hBox4;
	Text  fntext, lntext, agetext,text;
	Button udButton, addButton, delButton,sasButton, resetButton, clearButton, loadButton;
	TextField addFname, addLname, addAge;
	boolean click = true;
	//Person[] personArray;
	private static final String SERIALIZED_FILE_NAME = "Person.xml"; 
	
	
	ArrayList<Object> personList = new ArrayList<Object>();
	
	
	private TableView<Person> table = new TableView<Person>();
    private final ObservableList<Person> data =
        FXCollections.observableArrayList(
            new Person("Jacob", "  Smith", "   22"),
            new Person("Isabella", "  Johnson", "   34"),
            new Person("Ethan", "  Williams", "   55"),
            new Person("Emma", "  Jones", "   43"),
            new Person("Michael", "  Brown", "   24")
        );
       
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
      
     table.setEditable(true);
 
        TableColumn firstNameCol = new TableColumn("First Name");
        
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
 
        TableColumn lastNameCol = new TableColumn("Last Name");
        
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
 
        TableColumn ageCol = new TableColumn("Age");
       
        ageCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("age"));
 
        firstNameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));
		lastNameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
		ageCol.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		
       table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, ageCol);
 
       
        udButton = new Button("Update");
		addButton = new Button("Add");
		delButton = new Button("Delete");
		loadButton= new Button("LoadFile");
		hBox = new HBox(20);
		hBox.setAlignment(Pos.TOP_RIGHT);
		hBox.getChildren().addAll(loadButton, udButton, addButton, delButton);
	
		 addFname= new TextField();
		 addFname.setPromptText("First Name");
		 addLname= new TextField();
		 addLname.setPromptText("Last Name");
		 addAge= new TextField();
		 addAge.setPromptText("Age");
		 
		 loadButton.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
	            public void handle(ActionEvent e) {
			
			 XMLDecoder decoder = null;
				try {
					
					decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
					System.out.println("File stream opened and XMLDecoder created");

				personList = (ArrayList<Object>)decoder.readObject();
				decoder.close();
				
				System.out.println();
				//System.out.println("FistName Lastname and Age:\n");
				
				} catch (FileNotFoundException E) {
					System.out.println("ERROR: File Person.xml not found");
				}
			 
			 }
			 }); 
			 
		 
		 
		 addButton.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
	            public void handle(ActionEvent e) {
	                /*data.add*/
				 table.getItems().add(new Person(
	                        addFname.getText(),
	                        addLname.getText(),
	                        addAge.getText()));
	             
				  
	              personList.add(addFname.getText());
	              personList.add(addLname.getText());
	              
	              personList.add(addAge.getText());
	               
	                		addFname.clear();
	                		addLname.clear();
	                		addAge.clear();
	                		
	                		XMLEncoder encoder = null;
	    					try {
	    						
	    						encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
	    						System.out.println("File stream opened and XMLEncoder created");

	    					encoder.writeObject(personList);
	    					System.out.println("Object written");
	    					
	    					encoder.flush();
	    					encoder.close();
	    					System.out.println("File stream closed");
	    					
	    					
	    					} catch (FileNotFoundException fileNotFound) {
	    						System.out.println("ERROR: While Creating or Opening the File Person.xml");
	    					}	                	
	            }
			
		 });
		
		 delButton.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
	            public void handle(ActionEvent e) {
				    Person selectedItem = table.getSelectionModel().getSelectedItem();
				    table.getItems().remove(selectedItem);
				    addFname.setText("");
				    addLname.setText("");
				    addAge.setText("");
			 }
				});
			
		udButton.setOnAction(new EventHandler<ActionEvent>() {
			
			 @Override
	            public void handle(ActionEvent e) {
				 if (click) {
				    Person selectedItem = table.getSelectionModel().getSelectedItem();
				    String  fn = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getFirstName();
				    String  ln = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getLastName();
				    String  ag = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getAge();
				   
					     addFname.setText(fn);
					     addLname.setText(ln);
					     addAge.setText(ag);
					     table.getItems().remove(selectedItem);  
					     click= false;
				 }
				    
				      else {
				    	 
				    	 data.add(new Person(
			                        addFname.getText(),
			                        addLname.getText(),
			                        addAge.getText()));
				    	 
				    	 personList.add(addFname.getText());
			              personList.add(addLname.getText());
			              
			              personList.add(addAge.getText());
				    	 
				    	 		addFname.clear();
				    	 		addLname.clear();
				    	 		addAge.clear();
				    	 		
				    	 		XMLEncoder encoder = null;
		    					try {
		    						
		    						encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
		    						System.out.println("File stream opened and XMLEncoder created");

		    					encoder.writeObject(personList);
		    					System.out.println("Object written");
		    					
		    					encoder.flush();
		    					encoder.close();
		    					System.out.println("File stream closed");
		    					
		    					
		    					} catch (FileNotFoundException fileNotFound) {
		    						System.out.println("ERROR: While Creating or Opening the File Person.xml");
		    					}
		    					click = true;
		    					}
				    	 		
				     }
		               		
			 
				});	  
		
		
		
				
		fntext= new Text("First name:");
		lntext = new Text("Last name:");
		agetext = new Text("Age:          ");
	
		hBox1 = new HBox(350);
		hBox2 = new HBox(350);
		hBox3 = new HBox(350);
		hBox4= new HBox();
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


