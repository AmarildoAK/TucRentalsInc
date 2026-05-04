package cli;

import managers.TransactionManager;
import managers.UserManager;
import users.Customer;
import utils.MyScanner;

public class Individual {

	
	public static void IndividualMenu() {
		System.out.println(Globals.separetor);
		System.out.println(Globals.IndividualPrompt);
		int choice = MyScanner.readInt();
		switch (choice) {
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
			
			System.out.println("Give your VAT in order to pay the balance that you owe:");
			String VAT = MyScanner.readString();
			
		Customer selectedCustomer = UserManager.getInstance().findCustomer(VAT);
			
		System.out.println("Type the amount:");
		double amount = MyScanner.readDouble();	
		TransactionManager.getInstance().PayBalance(selectedCustomer,amount);
			break;
		}
		case 3:{
			System.out.println("Here is your transaction history:");// na fvnajo ton contract manager na checkaro an einai active to symbolaio kai na ftiajo mia print gia ayto print	ContractDetails
			break;// να φορτώσω τον statement manager και να τυπώσω όλες τις κινήσεις του χρήστη που έχουν καταγραφεί 
		}
		case 4:{
			System.out.println("exit the individual menu");
			System.exit(0);
			break;
		}
	}
}}
