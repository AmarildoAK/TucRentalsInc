	package cli;

import java.util.List;

import storage.StorageManager;
import users.Admin;
import users.Customer;
import utils.MyScanner;
import managers.TransactionManager;
import managers.UserManager;
import managers.VehicleManager;


public class AdminCLI {
	
public static void adminMenu(Admin login) {
System.out.println(Globals.separetor);
System.out.println(Globals.AdminPrompt);
System.out.println("Press 0 to go back to admin menu");

int choice = 0;


while(choice!=4) {
	
	choice = MyScanner.readInt();
	switch (choice) {

	
	case 0:{
		
		System.out.println(Globals.separetor);
		System.out.println(Globals.AdminPrompt);
		
		
		
		break;
	}
	
	
	
case 1: {
	
	System.out.println("Loading the vehicle fleet......");// na ftiajoyme mia methodo printVehivcles που θα τυπωνει τον στόλο και να την καλέσουμε 
	VehicleManager.getInstance().printVehicles();
	
	System.out.println("Type 0 to get back at the main admin menu");
	
	break;

}
case 2:{
	customerSubMenu();
	break;
}
case 3:{
	System.out.println("Give me a start Date");
	
	System.out.println("Give me an end Date");
	System.out.println("Staring the time simulation ");// ωραία άρα εδώ απλ΄ατο καλούμαι και έπειτα μέσα στην μέθοδο time passing ρωτάμε τονuser μέσα στο request processor
	
	
	System.out.println("Type 0 to get back at the main admin menu");
	break;
}
case 4:{
	
	System.out.println("exit admin menu");
	

	break;
}

default:{
	System.out.println("error");
	break;
}
}
}

}	
		




private static void customerSubMenu() {
	boolean back = false;
	
	while(!back) {
		
		System.out.println(Globals.separetor);
		System.out.println(Globals.CustomerAdminSubMenu);
		int choice = MyScanner.readInt();
		
		switch(choice) {
		
		case 1: {
			System.out.println("--USER LIST--");
			List<Customer> userlist = UserManager.getInstance().AllCustomerList();
		
			for(Customer c:userlist) {
				System.out.println(c.getName());
			}
			break;}
		
		case 2:{
			System.out.println("--USER BALANCE--");
		UserManager.getInstance().ShowBalanceOfAllUsers();
		break;
		}
		case 3:{
			System.out.println("--Transaction History Of selected user--");
	
			System.out.println("Give the VAT of the user you want to see:");
		String VAT = MyScanner.readString();
		
		Customer customer = UserManager.getInstance().findCustomer(VAT);
		
		TransactionManager.getInstance().showWalletStatementsOfUser(customer);
		break;}
		
		case 0:{
			back = true;
			break;}
			
		 default:{
		System.out.println("Wrong choice");	
		break;}
			
			
	}
}




}
}
