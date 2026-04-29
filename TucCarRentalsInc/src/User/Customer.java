package User;

import storage.Storable;
import storage.UnMarshalingException;
import transaction.Wallet;

public abstract class Customer extends user implements Storable {

	private int VAT;
	private Wallet balance;
	private String type;
	
	public Customer(int VAT,String name,String password) {
		super(password,name);
		this.VAT = VAT;
		this.balance = new Wallet(0.0);
	}


	public int getVAT() {
		return VAT;
	}


	private void setVAT(int vAT) {
		VAT = vAT;
	}


	
	
	private Wallet getBalance() {
		return balance;
	}


	private void setBalance(Wallet balance) {
		this.balance = balance;
	}


	public String marshal() {
		
		StringBuffer sb = new StringBuffer(super.marshal());
		
		sb.append("VAT:").append(this.VAT).append(",");
		sb.append("balance:").append(this.balance.getAmount()).append(",");
		sb.append("type:").append(this.type).append(",");
		
		return sb.toString();
	}
	
	
	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);
		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			if(keyValue[0].equals("VAT")) {
				this.VAT = Integer.parseInt(keyValue[1]);
			}else if(keyValue[0].equals("balance")) {
				
				double currentBalance = Double.parseDouble(keyValue[1]);
				this.balance = new Wallet(currentBalance);
			}else if(keyValue[0].equals("type")) {
				this.type = type;
			}
		
	}
	
	
	}	
	
}
