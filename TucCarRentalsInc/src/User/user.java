package User;

import Vehicles.Vehicles;
import storage.Storable;
import storage.UnMarshalingException;
import transaction.Wallet;

public abstract class user implements Storable,Comparable<user>{

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String username;
	private Wallet wallet;
	
	
	
	public user(String email, String password, String firstName, String lastName,String username) {
		
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	    this.username = username;
	
	}

	private String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		firstName = firstName;
	}

	private String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		lastName = lastName;
	}

	
	public String getUsername() {
		return username;
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
		
		
		sb.append("firstName:").append(this.firstName).append(",");
		sb.append("lastname").append(this.lastName).append(",");
		sb.append("password").append(this.password).append(",");
		
		return sb.toString();
	}
	
	
public void unmarshal(String data) throws UnMarshalingException {
		
	if(data == null) {
		throw new UnMarshalingException("Empty Data");
		}

		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
			if(keyValue[0].trim().equals("firstName")) {// ιδεα για επεκταση στην εξεταση μπορει να μας βαλλουν να αλλάξουμε τα marshall unmarsall  ανάλογα με το που χωρίζεται
				this.firstName = keyValue[1];
			}else if(keyValue[0].trim().equals("lastName")) {
				this.lastName = keyValue[1];
			}else if(keyValue[0].trim().equals("email")) {
				this.email = keyValue[1];
			}else if(keyValue[0].trim().equals("password")) {
				this.password = keyValue[1];
			}
		}
	
	
	
	
}




}