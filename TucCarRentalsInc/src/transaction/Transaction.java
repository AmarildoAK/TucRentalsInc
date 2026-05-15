package transaction;

import storage.Storable;
import storage.UnMarshalingException;
import users.Customer;

public abstract  class Transaction  implements Storable,Comparable<Transaction>{
// ρεφερψε ιδ να μπει
	private static int TransactionIdCounter =1;
	private String TransactionID;
	private double amount;
	private String name;// mhpos na mpei ayto se customer payment kai refund
	private Customer customer;
	private String referenceId;
	
	
	public Transaction(String ReferenceId,double amount) {
	
		
		this.amount=amount;
	}
	
	
	
	
	
	private String getReferenceId() {
		return referenceId;
	}





	private void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}





	public Customer getCustomer() {
		return customer;
	}





	private void setVAT(Customer customer) {
		customer = customer;
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
	public String getTransactionID() {
		return TransactionID;
	}
	private void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}


	@Override
	public String marshal() {
		StringBuffer sb = new StringBuffer("transactionType: ").append(this.getClass().getName()).append(";");

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
				this.TransactionID = keyValue[1];
			}else if(keyValue[0].trim().equals("ContractID")) {
				this.amount = Double.parseDouble(keyValue[1]);
			
		}
	}

	}



}
