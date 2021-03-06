package application;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
String accountNumber;
String password;
Double accountBalance;
String openingDate;
String latestTransaction;


public Customer(){

	
}


public String getAccountNumber(){
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber=accountNumber;
}


public String getPassword(){
	return password;
}

public void setPassword(String pass) {
	this.password=pass;
}



public Double getAccountBalance(){
	return accountBalance;
}

public void setAccountBalance(Double accountBalance) {
	this.accountBalance=accountBalance;
}

public String getOpeningDate(){
	return openingDate;
}

public void setOpeningDate(String openingDate) {
	this.openingDate=openingDate;
}


public String getLatestTransaction(){
	return latestTransaction;
}

public void setLatestTransaction(String latestTransaction) {
	this.latestTransaction=latestTransaction;
}



}




	