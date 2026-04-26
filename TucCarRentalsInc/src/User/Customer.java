package User;

import storage.Storable;
import storage.UnMarshalingException;
import transaction.Wallet;

public abstract class Customer extends user implements Storable {

	private int VAT;
	
	private Wallet wallet;// giati na valoyme ;olo to wallet m;esa prin fonajoyme thn ballance to akouw alla mhpvws e;inai overkill
	
	public Customer(int VAT,String firstName,String lastName,String email,String password,String username) {
		super(email,password,firstName,lastName,username);
		this.VAT = VAT;
		
	}


	public int getVAT() {
		return VAT;
	}


	private void setVAT(int vAT) {
		VAT = vAT;
	}


	
	
	public String marshal() {
		
		StringBuffer sb = new StringBuffer(super.marshal());
		sb.append("VAT").append(this.VAT).append(",");
		
		
		return sb.toString();
	}
	
	
	public void unmarshal(String data) throws UnMarshalingException {
		
		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			if(keyValue[0].equals("VAT")) {
				this.VAT = Integer.parseInt(keyValue[1]);
			
		}
		
	}
	
	
	}	
	
}
