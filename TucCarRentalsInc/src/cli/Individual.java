package cli;

import utils.MyScanner;

public class Individual {

	
	public static void IndividualMenu() {
		System.out.println(Globals.separetor);
		System.out.println(Globals.IndividualPrompt);
		int choice = MyScanner.nextInt();
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
			break;
		}
		case 3:{
			System.out.println("Here is your transaction history:");// na fvnajo ton contract manager na checkaro an einai active to symbolaio kai na ftiajo mia print gia ayto print	ContractDetails
			break;// να φορτώσω τον statement manager και να τυπώσω όλες τις κινήσεις του χρήστη που έχουν καταγραφεί 
		}
		case 4:{
			System.out.println("ΕΞΟΔΟΣ ΑΠΟ ΤΟ ΠΡΟΓΡΑΜΜΑ");
			System.exit(0);
			break;
		}
	}
}}
