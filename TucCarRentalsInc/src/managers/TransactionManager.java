package managers;


import User.user;
import storage.StorableList;
import transaction.Transaction;
import transaction.Wallet;

public class TransactionManager {

	private StorableList<Transaction> transactionList;
	private Transaction t;
private Wallet wallet;
	
	public TransactionManager() {
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
	
	
	
	
}
