package managers;

import java.util.ArrayList;
import java.util.List;

import Vehicles.Vehicles;
import users.Admin;
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
	
	
	
	
	

	public User authenticateAndLogin(String identifier,String password) {
	   

	    for (User user : userlist) {

       if(user instanceof Admin) {
    	   
    	   
    	   
       }
	        
	
	    }          
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
	
	
	
	
	

