package managers;

import User.user;
import storage.Storable;
import storage.StorableList;
import storage.StorageManager;

public class UserManager {

	private StorableList<user> userlist;
	public UserManager() {
		this.userlist = new StorableList<>();
		
		try {
			StorageManager.getInstance().loadObject(this.userlist,"Data/agents/agents.csv");
			System.out.println("The user have been added succesfully");
			
		}catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}
		
	}
	
	
	public user authenticate(String username, String password) {

		for (int i = 0; i < userlist.size(); i++) {

			if (userlist.get(i).getUsername().equals(username) && userlist.get(i).getPassword().equals(password)) {
				return userlist.get(i);
			}

		}

		return null;
	}
	
	
	public void saveUser() {
		
		try {
			StorageManager.getInstance().storeObject(userlist,"Data/agents/agents.csv");
			System.out.println("The user has been stored succesfully");
		}catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}
		
		
	}
	
	
	
	
	
	
	}
	
	
	
	
	

