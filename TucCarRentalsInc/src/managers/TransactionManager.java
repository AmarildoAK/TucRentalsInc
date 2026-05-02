package managers;


import java.util.ArrayList;
import java.util.List;

import User.Customer;
import User.user;
import storage.StorableList;
import transaction.Transaction;
import transaction.Wallet;

public class TransactionManager {

	private StorableList<Transaction> transactionList;
	private Transaction t;
private Wallet wallet;
	
private static TransactionManager instance;

public static TransactionManager getInstance() {
	if(instance == null) {
	 instance = new TransactionManager();
	}
return instance;
}

	private  TransactionManager() {
		this.transactionList = new StorableList<>();
		
		
		
		
	}
	
	public Transaction findTransaction(int TransactionID) {
		
		for(int i=0;i<transactionList.size();i++) {
			if(transactionList.get(i).getTransactionID() == TransactionID) {
				return transactionList.get(i);
			}
		}
		return null;
	}
	
	
	
	public boolean addCharge(Transaction newCharge) {
		if(findTransaction(newCharge.getTransactionID())!= null) {
			return false;
		}else {
			transactionList.add(newCharge);
			return true ;
		}
	}
	
	public void UpdateWallet(user customer,double newWallet) {// να κάνουμε τύπου customer και να κάνουμε έτσι accessτο wallet καθε customer
	customer.getWallet().setAmount(newWallet);
	}
	
public boolean addCredit(Transaction newCredit) {
	
	if(findTransaction(newCredit.getTransactionID())!=null) {
		return false;
	}else {
		transactionList.add(newCredit);
	return true;
	}
	
}
	
	public void PayBalance(Customer customer, double amount) {
		
		Wallet customerWallet = customer.getWallet();
		
		customerWallet.setAmount(amount);
		
		System.out.println("The payment has been completed");
		
		
	}
	
	
	public List<Transaction> showWalletStatementsOfUser(Customer VAT){ // to megalo kommatitha ginei sto cli kai mhpws prepei na ginei typou customer h string na to skeftw  
		
		List<Transaction> customerStatementHistoryWallet = new ArrayList<>();
		
		
	for(Transaction t: this.transactionList) {
		
		if(t.getVAT() == VAT) {
			
			
			customerStatementHistoryWallet.add(t);
			
		}
		
		
	}
		
	return customerStatementHistoryWallet;
	
	}
	
	
	
	
	
}
