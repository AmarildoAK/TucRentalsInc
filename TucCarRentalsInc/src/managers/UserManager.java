package managers;

import User.user;
import storage.Storable;
import storage.StorableList;
import storage.StorageManager;

public class UserManager {

	private StorableList<user> userlist;
	private int UserCount = 0 ;
	private user u;
	public UserManager() {
		this.userlist = new StorableList<>();
		
		try {
			StorageManager.getInstance().loadObject(this.userlist,"agents.csv");
			System.out.println("The user have been added succesfully");
			
		}catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}
		
	}
	
	
	public user authenticate(String username, String password) {

		for (int i = 0; i < UserCount; i++) {

			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}

		}

		return null;
	}
	
	
	public void saveUser() {
		
		try {
			StorageManager.getInstance().storeObject(userlist,"agents.csv");
			System.out.println("The user has been stored succesfully");
		}catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}
		
		
	}
	
	
	
	
	
	
	}
	
	
	
	
	

