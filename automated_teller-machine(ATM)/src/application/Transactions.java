package application;

public class Transactions {

	Double  withDrawCash(Double withdra_amt, Double acct_bal) {//withdrawal



		Double balance = acct_bal- withdra_amt;

		return balance;
		}
	
	Double insertCash( Double insert_amt,Double cur_bal) {//insert cash
		
		
		Double balance = insert_amt+ cur_bal;
		return balance;
		
	}
	
	Double viewBalance(Customer customer) {//View Balance
		Double balance= customer.accountBalance;
		return balance;
	}
}
