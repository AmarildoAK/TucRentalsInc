package managers;

import java.util.ArrayList;
import java.util.List;

import Vehicles.Vehicles;
import cli.Admin;
import storage.Storable;
import storage.StorableList;
import storage.StorageManager;
import transaction.Wallet;
import users.Company;
import users.Customer;
import users.Individual;
import users.User;
import utils.MyScanner;


public class UserManager {

	
	
	
	
	private User user;
	private StorableList<User> userlist;
	
	private static UserManager instance;
	
	public static UserManager getInstance() {
		if(instance == null) {
			instance = new UserManager();
		}
	return instance;
	}
	
	private  UserManager() {
		this.userlist = new StorableList<>();
		
		try {
			StorageManager.getInstance().loadObject(this.userlist,"Data/agents/agents.csv");
			System.out.println("The user have been added succesfully");
			
		}catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}
		
	}
	
	
	
	
	

	public User authenticateAndLogin() {
	    System.out.print("Enter Username/VAT: ");
	    String username =  MyScanner.readString();
	    System.out.print("Enter Password: ");
	    String password = MyScanner.readString();


	    for (User user : userlist) {


	        if (user.getName().equals(username) && user.getPassword().equals(password)) {
	
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
		
	public Customer findCustomer(String VAT) {
		for(int i=0;i<userlist.size();i++) {
			User u = userlist.get(i);
			
			if(u instanceof Customer) {
				Customer customer = (Customer)u;
				
				if(customer.getVAT().equals(VAT)) {
					return customer;
				}
			}
			
		}
	return null;
	}
	
public void showBalance(Customer customer) {
	
	if(customer !=null) {
		Wallet customerWallet = customer.getWallet();
		System.out.println(customerWallet.getAmount());
	
	}else {
		System.out.println("There has been an error trying to print the balance of the user");
	return;
	}
}


public void ShowBalanceOfAllUsers() {
	
	for(User u: userlist) {
		if (u instanceof Customer) {
			Customer c= (Customer) u;
			showBalance(c);
		}
	}
	
}


public List<Customer> AllCustomerList(){ // opote tha kaloume thn synarthsh auth sto cli opou auth h synarthsh exei oles tis aparaithtes plhrofories pou tha thelame na paroume 
	List<Customer> customerlist = new ArrayList<>();
	
	for(User u:this.userlist) {
		if(u instanceof Customer) {
			customerlist.add((Customer) u);
		}
	}
return customerlist;
}





}
	
	
	
	
	

