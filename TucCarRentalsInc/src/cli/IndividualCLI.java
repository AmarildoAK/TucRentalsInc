package cli;

import managers.ContractManager;
import managers.StatementManager;
import managers.TransactionManager;
import managers.UserManager;
import users.Customer;
import users.Individual;
import utils.MyScanner;

public class IndividualCLI {

	
	public static void IndividualMenu(Individual login) {
		System.out.println(Globals.separetor);
		System.out.println(Globals.IndividualPrompt);
		int choice = 0;
		while(choice!=4) {
			
			choice = MyScanner.readInt();
		switch (choice) {
		 
		
		case 0:{
			System.out.println(Globals.separetor);
			System.out.println(Globals.IndividualPrompt);
			break;
		}
		case 1: {
			System.out.println("Showing the balance overview of the user .......");
	
			System.out.println("Balance: "+login.getBalance().getAmount());//ayto mhpws na ginei methodos?
	
			System.out.println("Active contracts:...");
			System.out.println(ContractManager.getInstance().getInMotionContracts(login));
			
			System.out.println("Future contracts:");
			System.out.println(ContractManager.getInstance().getFutureContracts(login));
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
			
			String transactionHistory = StatementManager.getInstance().getAllUserStatements(login.getVAT());
			System.out.println(transactionHistory);
			
			break;// να φορτώσω τον statement manager και να τυπώσω όλες τις κινήσεις του χρήστη που έχουν καταγραφεί 
		}
		case 4:{
			System.out.println("exit the individual menu");
			
			break;
		}
		}
		}
}}
