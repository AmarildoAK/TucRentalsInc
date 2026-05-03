package cli;

import User.Customer;
import managers.TransactionManager;
import managers.UserManager;
import utils.MyScanner;

public class Company {
public static  void companyMenu() {// mhpws aytes tis methodoys na tis kano static?
	System.out.println(Globals.separetor);
	System.out.println(Globals.CompanyPrompt);
	int choice = MyScanner.readInt();
	switch (choice) {
	
	// pali prepei na kano ena parathyro login ;h register kai meta na fortwsw ton xrhsth an einai login
	case 1: {
		System.out.println("Showing the balance overview of the user .......");
		// kai pairno to wallet toy user
		System.out.println("Balance: ");//ayto mhpws na ginei methodos?
		System.out.println("Active contracts:...");
		System.out.println("Other contarcts: "+"Status: ");
		break;
	}
	case 2:{
		System.out.println("Executing payment transaction....");// na fww=najo ton transcation manager
		
		System.out.println("Give the VAT of the company");
		String VAT = MyScanner.readString();
		
		
		
		Customer selectedCustomer = UserManager.getInstance().findCustomer(VAT);
		
		System.out.println("Type the amount");
		double amount = MyScanner.readDouble();
		TransactionManager.getInstance().PayBalance(selectedCustomer,amount);

		
		break;
	}
	case 3:{
		System.out.println("Here are your active contracts:");// na fvnajo ton contract manager na checkaro an einai active to symbolaio kai na ftiajo mia print gia ayto print	ContractDetails
		break;
	}
	case 4:{
		System.out.println("ΕΞΟΔΟΣ ΑΠΟ ΤΟ ΠΡΟΓΡΑΜΜΑ");
		System.exit(0);
		break;
	}}
	
	
	
	
	
	
}
}
