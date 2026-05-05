package cli;

import utils.MyScanner;

public class Menu {

public static void main(String[] args) {
	// αρχικασ να φοα να μην γρτώσω όλη την λίστα μέσα στο manager και τις λίστυες τουες γίονεται το προγραμμα 
	AdminCLI aCli;
	CompanyCLI compCli;
	IndividualCLI iCli;
	
	
	while(true) {
	System.out.println(Globals.separetor);
	System.out.println(Globals.LoginPrompt);
	 int choice = MyScanner.readInt();
	 
	 if(choice == 4) {
		 System.out.println("EXITING THE PROGRAM");
		 System.exit(0);
	 }
	 
	 
	    System.out.print("Enter Username/VAT: ");
	    String username =  MyScanner.readString();
	    System.out.print("Enter Password: ");
	    String password = MyScanner.readString();

	

	}
}
}