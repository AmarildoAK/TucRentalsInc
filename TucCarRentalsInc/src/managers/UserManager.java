package managers;

import User.Company;
import User.Customer;
import User.Individual;
import User.user;
import Vehicles.Vehicles;
import cli.Admin;
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
	
	
	
	
	
	public user authenticateAndLogin() {
	    System.out.print("Enter Username/VAT: ");
	    String username = scan.next().String;
	    System.out.print("Enter Password: ");
	    String password = scan.next().String;

	    for (user user : userlist) {

	        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
	
	            if (user instanceof Admin) {
	            	System.out.println("Welcome Admin");
	                return (Admin) user;
	            } else if (user instanceof Individual) {
	            	System.out.println("Welcome Individual");
	                return (Individual) user;
	            } else if (user instanceof Company) {
	               	System.out.println("Welcome Company");
	                return (Company) user;
	            } else {
	                return user; // Return as base User if no specific subclass match
	            }
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
	
	
	
	
	

