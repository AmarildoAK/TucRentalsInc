	package cli;

import java.util.List;

import storage.StorageManager;
import users.Customer;
import utils.MyScanner;
import managers.TransactionManager;
import managers.UserManager;
import managers.VehicleManager;


public class Admin {
	
public void adminMenu() {
System.out.println(Globals.separetor);
System.out.println(Globals.AdminPrompt);
int choice = MyScanner.readInt();

// kapou edo prepei na elegxw to login toy xrhsth
//Επίσης στο cli λογικά δεν πρέπει να βάλουμε και άλλο ένα switchcase που θα ξεχωρίζει το login με το register??
switch (choice) {
case 1: {
	
	System.out.println("Loading the vehicle fleet......");// na ftiajoyme mia methodo printVehivcles που θα τυπωνει τον στόλο και να την καλέσουμε 
	VehicleManager.getInstance().printVehicles();
	break;
}
case 2:{
	customerSubMenu();
	break;
}
case 3:{
	System.out.println("Staring the time simulation ");// ωραία άρα εδώ απλ΄ατο καλούμαι και έπειτα μέσα στην μέθοδο time passing ρωτάμε τονuser μέσα στο request processor
	break;
}
case 4:{
	System.out.println("");
	System.exit(0);
	break;
}
default:{
	System.out.println("error");
	break;
}
		
		
		}
}



private void customerSubMenu() {
	boolean back = false;
	
	while(!back) {
		
		System.out.println(Globals.separetor);
		System.out.println(Globals.CustomerAdminSubMenu);
		int choice = MyScanner.readInt();
		
		switch(choice) {
		
		case 1: 
			System.out.println("--USER LIST--");
			List<Customer> userlist = UserManager.getInstance().AllCustomerList();
		
			for(Customer c:userlist) {
				System.out.println(c.getName());
			}
			break;
		
		case 2:
			System.out.println("--USER BALANCE--");
		UserManager.getInstance().ShowBalanceOfAllUsers();
		break;
		
		case 3:
			System.out.println("--Transaction History Of selected user--");
	
			System.out.println("Give the VAT of the user you want to see:");
		String VAT = MyScanner.readString();
		
		Customer customer = UserManager.getInstance().findCustomer(VAT);
		
		TransactionManager.getInstance().showWalletStatementsOfUser(customer);
		break;
		
		case 0:
			back = true;
			break;
			
		 default:
		System.out.println("Wrong choice");	
		break;
			
			
	}
}




}
}
