package User;

import Vehicles.Vehicles;
import storage.Storable;
import storage.UnMarshalingException;
import transaction.Wallet;

public abstract class user implements Storable,Comparable<user>{

	
	private String password;
	private String name;
	
	private String username;
	private Wallet wallet;
	private String type;
	
	
	public user( String password, String name) {
		
		if(CheckUsername(username)&&CheckPassword(password)) {
		this.password = password;
	    this.username = username;
		}
	}



	public String getPassword() {
		return password;
	}

	
	private boolean CheckPassword(String password) {
		return password!= null && !password.trim().isEmpty();
	}
	
	private void setPassword(String password) {
		
		if(password !=null && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")) {
			this.password = password;
		}else {
			System.out.println("There is an error with the password you typed");
		}
	}



	
	public String getUsername() {
		return username;
	}

	
	private boolean CheckUsername(String username) {
		return this.username!=null && !username.trim().isEmpty();
	}
	
	
	private void setUsername(String username) {
		this.username = username;
	}

	public Wallet getWallet() {
		return wallet;
	}

	private void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public String marshal() {
		StringBuffer sb = new StringBuffer("type: ").append(this.getClass().getName()).append(";");
		
		
		
		sb.append("password:").append(this.password).append(",");
		sb.append("name:").append(this.name).append(",");
		sb.append("type:").append(this.type).append(",");
		
		return sb.toString();
	}
	
	
public void unmarshal(String data) throws UnMarshalingException {
		
	if(data == null) {
		throw new UnMarshalingException("Empty Data");
		}

		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
			if(keyValue[0].trim().equals("name")) {// ιδεα για επεκταση στην εξεταση μπορει να μας βαλλουν να αλλάξουμε τα marshall unmarsall  ανάλογα με το που χωρίζεται
				this.name = keyValue[1];
		}
			else if(keyValue[0].trim().equals("username")) {
				this.username = keyValue[1];
			}
		}
	
	
	
	
}

@Override
public int compareTo(user other ) {
	return this.username.compareTo(other.username);
}

}