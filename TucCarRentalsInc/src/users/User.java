package users;

import Vehicles.Vehicles;
import storage.Storable;
import storage.UnMarshalingException;
import transaction.Wallet;

public abstract class User implements Storable,Comparable<User>{

	
	private String password;
	private String name;
	private Wallet wallet;
	private String type;
	
	
	public User( String password, String name) {
		
		if(Checkname(name)&&CheckPassword(password)) {
		this.password = password;
	    this.name = name;
		}
	}
	public User() {}



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



	

	
	private boolean Checkname(String name) {
		return this.name!=null && !name.trim().isEmpty();
	}
	
	
	public String getName() {
		return name;
	}



	private void setName(String name) {
		this.name = name;
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
		}else if(keyValue[0].trim().equals("password")){
			this.password = keyValue[1];
		}
			
		}
	
	
	
	
}

@Override
public int compareTo(User other ) {
	return this.name.compareTo(other.name);
}

}