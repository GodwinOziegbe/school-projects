package application;


import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {
private static final String SERIALIZED_FILE_NAME = "Customer.xml";	

private TextField tfWithdrawal  = new TextField();
private TextField tfDeposit = new TextField();
private TextField tfAccount = new TextField();
private PasswordField tfpassword1 = new PasswordField();
private PasswordField tfpassword2 = new PasswordField();
private PasswordField tfpassword3 = new PasswordField();
private PasswordField tfpassword4 = new PasswordField();
private PasswordField tfpassword5 = new PasswordField();
private PasswordField tfpassword6 = new PasswordField();
private TextField tfAccount1 = new TextField();
private TextField tfAccount2 = new TextField();
private TextField tfAccount3 = new TextField();
private TextField tfAccount4 = new TextField();

Button withdrawalButton;
Button depositButton;
Button accountButton;
Button logoutButton1;
Button enterButton1;
Button logoutButton2;
Button enterButton2;
Button logoutButton3;
Button loadButton;
Button menuButton1;
Button menuButton2;
Button menuButton3;
Button menuButton4;
Button menuButton5;
Button menuButton6;
Button menuButton7;
Button savelistButton;
Button loginoutButton;
Button loginButton;
Button createButton;
Button newaccountButton;
Button viewButton;
HBox hbox1, hbox2;
VBox vbox1;
Scene scene0,scene1,scene2,scene3,scene4,scene5,scene6,scene7;
String currentBal;
Text currentText,text,text1,text2, text3,accttext,baltext, opdatetext,latranstext;
String acct_nr, pass, acct1, pass1;
Customer currentCust;
ArrayList<Customer> customerList = new ArrayList<Customer>();
Boolean balance_check=true;


@Override // Override the start method in the Application class
 public void start(Stage primaryStage) {
//Create UI
	withdrawalButton = new Button("Withdraw Cash");
	depositButton = new Button("Deposit Cash");
	accountButton = new Button("View Account");
	enterButton1 = new Button("Enter");
	logoutButton2 = new Button("Logout");
	enterButton2 = new Button("Enter");
	menuButton1= new Button("Main Menu");
	menuButton2= new Button("Main Menu");
	menuButton3= new Button ("Main Menu");
	menuButton4 = new Button("Main Menu");
	menuButton5 = new Button("Main Menu");
	menuButton6 = new Button("Main Menu");
	menuButton7 = new Button("Main Menu");
	viewButton = new Button("View");
	savelistButton= new Button("Save List");
	loginoutButton = new Button("Login");
	loginButton = new Button("Login");
	newaccountButton = new Button("New Account");
	createButton = new Button("Add Customer");
	loadButton = new Button("Load Customers");
	
	currentText = new Text(currentBal);
	text = new Text("");
	text1 = new Text("");
	text2 = new Text("");
	text3 = new Text("");
	accttext= new Text("Kontornr: ");
	baltext= new Text("Saldo: ");
	opdatetext= new Text("Skapat datum: ");
	latranstext= new Text("Senaste transaktion: ");
	vbox1 = new VBox(30);
	hbox1 = new HBox(20);
	hbox2 = new HBox(10);
	hbox1.setAlignment(Pos.TOP_LEFT);
	hbox2.setAlignment(Pos.CENTER);
	vbox1.setAlignment(Pos.TOP_LEFT);
	
	GridPane gridPane1 = new GridPane();
	GridPane gridPane2 = new GridPane();
	GridPane gridPane3 = new GridPane();
	GridPane gridPane4 = new GridPane();
	GridPane gridPane5 = new GridPane();
	GridPane gridPane6 = new GridPane();
	GridPane gridPane7 = new GridPane();
	gridPane1.setHgap(5);
	gridPane1.setVgap(10);
	gridPane2.setHgap(5);
	gridPane2.setVgap(10);
	gridPane3.setHgap(5);
	gridPane3.setVgap(10);
	gridPane4.setHgap(5);
	gridPane4.setVgap(10);
	gridPane5.setHgap(5);
	gridPane5.setVgap(10);
	gridPane6.setHgap(5);
	gridPane6.setVgap(10);
	gridPane1.setAlignment(Pos.CENTER);
	gridPane2.setAlignment(Pos.CENTER);
	gridPane3.setAlignment(Pos.CENTER);
	gridPane4.setAlignment(Pos.CENTER);
	gridPane5.setAlignment(Pos.TOP_CENTER);
	gridPane6.setAlignment(Pos.TOP_CENTER);
	tfWithdrawal.setAlignment(Pos.BOTTOM_RIGHT);
	tfDeposit.setAlignment(Pos.BOTTOM_RIGHT);
	tfpassword1.setAlignment(Pos.BOTTOM_RIGHT);
	tfAccount.setAlignment(Pos.BOTTOM_RIGHT);
	tfAccount1.setAlignment(Pos.BOTTOM_RIGHT);
	
	gridPane1.add(new Label("Your account nr: "), 0, 1);
	gridPane1.add(tfAccount3, 1, 1);
	gridPane1.add(new Label("Withdrawal amount:"), 0, 2);
	gridPane1.add(tfWithdrawal, 1, 2);
	gridPane1.add(new Label("Password:"), 0, 3);
	gridPane1.add(tfpassword4, 1, 3);
	gridPane1.add(enterButton1, 2,5);
	gridPane1.add(menuButton4, 2,0);
	gridPane1.add(text2, 0, 4);
	
	gridPane2.add(new Label("Enter Account number:"), 0, 1);
	gridPane2.add(tfAccount2, 1, 1);
	gridPane2.add(new Label("Deposit amount:"), 0, 2);
	gridPane2.add(tfDeposit, 1, 2);
	gridPane2.add(new Label("Password:"),0,3);
	gridPane2.add(tfpassword5, 1, 3);
	gridPane2.add(enterButton2, 2,5);
	gridPane2.add(menuButton6, 2,0);
	gridPane2.add(text3, 0,4);
	
	//accountButton
	gridPane3.add(new Label("Kontornr:"), 0, 1);
	gridPane3.add(accttext, 1, 1);
	gridPane3.add(new Label("Saldo:"), 0, 2);
	gridPane3.add(baltext,1 ,2);
	gridPane3.add(new Label("Skapat datum:"), 0, 3);
	gridPane3.add(opdatetext,1,3);
	gridPane3.add(new Label("Senaste transaktion:"), 0, 4);
	gridPane3.add(latranstext,1,4);
	gridPane3.add(menuButton5, 2,0);
	//loginoutButton
	gridPane4.add(new Label("Enter Accountnr:"), 0, 1);
	gridPane4.add(tfAccount1, 1, 1);
	gridPane4.add(new Label("Enter Password:"), 0, 2);
	gridPane4.add(tfpassword3, 1, 2);
	gridPane4.add(loginButton, 0, 3);
	gridPane4.add(newaccountButton, 1, 3);
	gridPane4.add(menuButton2, 2, 3);
	
	//newaccountButton
	gridPane5.add(new Label("Enter new account number:"), 0, 1);
	gridPane5.add(tfAccount, 1, 1);
	gridPane5.add(new Label("Enter new password:"), 0, 2);
	gridPane5.add(tfpassword1, 1, 2);
	gridPane5.add(new Label("Re-Enter the password:"), 0, 3);
	gridPane5.add(tfpassword2, 1,3);
	gridPane5.add(createButton, 0, 4);
	gridPane5.add(menuButton1, 1, 4);
	gridPane5.add(text, 0, 5);
	gridPane5.add(savelistButton,0,6);
	
	//loginButton
	gridPane6.add(text1, 0, 1);
	gridPane6.add(menuButton3, 0, 2);
	//viewaccountButton
	gridPane7.add(new Label("Enter Accountnr:"), 0, 1);
	gridPane7.add(tfAccount4, 1, 1);
	gridPane7.add(new Label("Enter Password:"), 0, 2);
	gridPane7.add(tfpassword6, 1, 2);
	gridPane7.add(viewButton, 0, 3);
	gridPane7.add(menuButton2, 1, 3);
	
hbox1.getChildren().addAll(withdrawalButton, depositButton, accountButton, newaccountButton);
	
menuButton4.setOnAction(e -> primaryStage.setScene(scene0));	
logoutButton2.setOnAction(e -> primaryStage.setScene(scene0));
menuButton5.setOnAction(e -> primaryStage.setScene(scene0));
menuButton1.setOnAction(e -> primaryStage.setScene(scene0));
//withdrawalButton.setOnAction(e -> primaryStage.setScene(scene2)withDrawCash());
depositButton.setOnAction(e -> primaryStage.setScene(scene2));
//balanceButton.setOnAction(e -> primaryStage.setScene(scene3));
//enterButton1.setOnAction(e -> primaryStage.setScene(scene0));
enterButton2.setOnAction(e -> primaryStage.setScene(scene0));
//enterButton2.setOnAction(e -> primaryStage.setScene(scene0));
//loginoutButton.setOnAction(e -> primaryStage.setScene(scene4));
newaccountButton.setOnAction(e -> primaryStage.setScene(scene5));
menuButton2.setOnAction(e -> primaryStage.setScene(scene0));
menuButton3.setOnAction(e -> primaryStage.setScene(scene0));
loginButton.setOnAction(e -> primaryStage.setScene(scene6));
menuButton6.setOnAction(e -> primaryStage.setScene(scene0));
menuButton7.setOnAction(e -> primaryStage.setScene(scene0));
viewButton.setOnAction(e -> primaryStage.setScene(scene3));

scene0= new Scene(hbox1,500,350);
scene1= new Scene(gridPane1,450,250);
scene2= new Scene(gridPane2,400,250);
scene3= new Scene(gridPane3,500,250);
scene4= new Scene(gridPane4,400,250);
scene5= new Scene(gridPane5,400,250);
scene6= new Scene(gridPane6, 400,250);
scene7= new Scene(gridPane7, 400,250);


withdrawalButton.setOnAction(new EventHandler<ActionEvent>() {
	
	@Override
	public void handle(ActionEvent event) {
		primaryStage.setScene(scene1);
		
		}
			
});

enterButton1.setOnAction(new EventHandler<ActionEvent>() {//Enter button in Withdrawal
	@Override
	public void handle(ActionEvent event) {
		
			String wrongpass1="Wrong Password!";
			
			String wit_amt=tfWithdrawal.getText();
			Double amount= Double.parseDouble(wit_amt);
			 String acct1= tfAccount3.getText();
			pass1 = tfpassword4.getText();
			 LoggingIn loggin = new LoggingIn();
			ArrayList<Customer>currentList = loggin.VerifyCustomer(acct1,pass1);
			
			for(Customer value:currentList)
			   { 
			     if(value.getAccountNumber().equals(acct1) && value.getPassword().equals(pass1)) {
			    	 
			    	 Double withdra_amt= Double.parseDouble(wit_amt);
			 		
			 		Transactions transac= new Transactions();
			 		
			 		Double acct_bal=value.getAccountBalance();
			 		if(acct_bal< amount) {
			 			text2.setText("insufficient amount");
			 			break;
			 		}
			 		Double new_balance=transac.withDrawCash(withdra_amt, acct_bal);
			 		
			 		String latest_tran=("Cash Withdrawal: "+wit_amt+ ", datestamp:"+ myDate());
			 		value.setAccountBalance(new_balance);
			 		value.setLatestTransaction(latest_tran);
			 		
			 		currentList.add(value);
			 		SaveCustomers save= new SaveCustomers();
			 		save.saveCustomerData(currentList);
			 		
			    	break; 

			     } 	
			     else {text1.setText(wrongpass1);}
			   }
			
			tfWithdrawal.clear();
			tfAccount3.clear();
			tfpassword4.clear();
			
		
	}
});


enterButton2.setOnAction(new EventHandler<ActionEvent>() {//Enter Button in Deposit Cash
	
	@Override
	public void handle(ActionEvent event) {
		primaryStage.setScene(scene0);
		Double dep_cash= Double.parseDouble(tfDeposit.getText());
		String wrongpass1="Wrong Password!";
		String acct1=tfAccount2.getText();
		String pass1 = tfpassword5.getText();
		 LoggingIn loggin = new LoggingIn();
		ArrayList<Customer>currentList5 = loggin.VerifyCustomer(acct1,pass1);
		
		for(Customer value:currentList5)
		   { 
		     if(value.getAccountNumber().equals(acct1) && value.getPassword().equals(pass1)) {
		    	 Transactions trans= new Transactions();
		    	 Double actbal=value.getAccountBalance();
		 		Double newbal=trans.insertCash(dep_cash, actbal);
		 		
		 		String latest_tran=("Cash Withdrawal: "+dep_cash+ ", datestamp:"+ myDate());
		 		value.setAccountBalance(newbal);
		 		value.setLatestTransaction(latest_tran);
		 		
		 		currentList5.add(value);
		 		SaveCustomers save= new SaveCustomers();
		 		save.saveCustomerData(currentList5);
		 		
		    	break; 
		
		    	}
		     else {primaryStage.setScene(scene2);
		    		currentText.setText(wrongpass1);
		    	}
		   }
		tfAccount2.clear();
		tfDeposit.clear();
		tfpassword5.clear();
	
	}
		
});


createButton.setOnAction(new EventHandler<ActionEvent>() {
	
	@Override
	public void handle(ActionEvent event) {
	
		String wrongpass="Password fields does not match!";
		String successMessage="Account creation successful";	
		
		String acct =tfAccount.getText();
		String pass=tfpassword1.getText();
		if (pass.equals( tfpassword2.getText())) {
			
			text.setText(successMessage);
			
			Double acct_bal= 0.0;
			String open_date= myDate();
			String lat_trans= "none";
			
			Customer customer = new Customer();
			
			customer.setAccountNumber(acct);
			customer.setPassword(pass);
			customer.setAccountBalance(acct_bal);
			customer.setOpeningDate(open_date);
			customer.setLatestTransaction(lat_trans);
			
			customerList.add(customer);
		
		
		} else {text.setText(wrongpass); } 
		
	tfAccount.clear();
	tfpassword1.clear();
	tfpassword2.clear();
	
	}
});

accountButton.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent event) {
		primaryStage.setScene(scene7);
	
}
});

viewButton.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent event) {
		primaryStage.setScene(scene3);

		String bal;
		 String acct1= tfAccount4.getText();
		pass1 = tfpassword6.getText();
		 LoggingIn loggin = new LoggingIn();
		ArrayList<Customer>currentList = loggin.VerifyCustomer(acct1,pass1);
		
		for(Customer value:currentList)
		   { 
		     if(value.getAccountNumber().equals(acct1) && value.getPassword().equals(pass1)) {
		    	 bal = value.getAccountBalance().toString();
		    	 accttext.setText(acct1);
		    	 baltext.setText(bal);
		    	 opdatetext.setText(value.getOpeningDate());
		    	 latranstext.setText(value.getLatestTransaction());
		    	 
		 		
		    	break; 

		     }
	
		else {
			accttext.setText("invalid account or password");
		}
		   }
		
		tfAccount4.clear();
		tfpassword6.clear();
		
		   	
}});
		
	

 menuButton1.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent event) {
		primaryStage.setScene(scene0);
		
		
	}

});
 
 savelistButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			primaryStage.setScene(scene0);
			
			SaveCustomers savecust = new SaveCustomers();
			savecust.saveCustomerData(customerList);
		}

	});
 
 
//Create a scene and place it in the stage 

primaryStage.setTitle("ATM"); // Set title
primaryStage.setScene(scene0); // Place the scene in the stage
primaryStage.show(); // Display the stage
	
}


String myDate() {// function to generate date time
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	String dateString = format.format(new Date());

	return dateString;

}


public static void main(String[] args) {
launch(args);
}

}