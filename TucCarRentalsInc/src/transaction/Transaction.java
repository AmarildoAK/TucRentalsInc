package transaction;

import User.Customer;
import storage.Storable;
import storage.UnMarshalingException;

public abstract  class Transaction  implements Storable,Comparable<Transaction>{
// ρεφερψε ιδ να μπει
	private static int TransactionIdCounter =1;
	private int TransactionID;
	private double amount;
	private String name;// mhpos na mpei ayto se customer payment kai refund
	private Customer VAT;
	
	
	
	public Transaction(int transactionID,double amount) {
	
		setTransactionID(TransactionIdCounter++);
		this.amount=amount;
	}
	
	
	
	
	
	public Customer getVAT() {
		return VAT;
	}





	private void setVAT(Customer vAT) {
		VAT = vAT;
	}





	public double getAmount() {
		return amount;
	}
	private void setAmount(double amount) {
		this.amount = amount;
	}
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public int getTransactionID() {
		return TransactionID;
	}
	private void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}


	@Override
	public String marshal() {
		StringBuffer sb = new StringBuffer("type: ").append(this.getClass().getName()).append(";");

		sb.append("amount").append(this.amount).append(",");
		sb.append("TransactionID").append(this.TransactionID).append(",");

		return sb.toString();

	
	}

	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		
		if(data == null) {
			throw new UnMarshalingException("Empty Data");
			}
		
		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
			if(keyValue[0].trim().equals("Status")) {
				this.TransactionID = Integer.parseInt(keyValue[1]);
			}else if(keyValue[0].trim().equals("ContractID")) {
				this.amount = Double.parseDouble(keyValue[1]);
			
		}
	}

	}



}
