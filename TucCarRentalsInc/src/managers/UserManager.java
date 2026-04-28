package managers;

import User.Customer;
import User.user;
import Vehicles.Vehicles;
import storage.Storable;
import storage.StorableList;
import storage.StorageManager;
import utils.MyScanner;

public class UserManager {
private user user;
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
	
	
	
	
	
	public user authenticate() {
		
		MyScanner username=next.String;
		MyScanner password=nextString;

		for (int i = 0; i < userlist.size(); i++) {

<<<<<<< HEAD
			if (userlist.get(i).getUsername().equals(username) && userlist.get(i).equals(password)) {
				System.out.println("The user has been loged in succesfully");
				return u;
=======
			if (userlist.get(i).getUsername().equals(username) && userlist.get(i).getPassword().equals(password)) {
				return userlist.get(i);
>>>>>>> branch 'master' of https://github.com/AmarildoAK/TucRentalsInc
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
	
	
	
	public Customer findCustomer(int VAT) {
		for(int i=0;i<userlist.size();i++) {
			user u = userlist.get(i);
			
			if(u instanceof Customer) {
				Customer customer = (Customer)u;
				
				if(customer.getVAT() == VAT) {
					return customer;
				}
			}
			
		}
	return null;
	}
	
	
	}
	
	
	
	
	

