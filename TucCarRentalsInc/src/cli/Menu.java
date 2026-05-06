package cli;

import managers.UserManager;
import users.Admin;
import users.Company;
import users.Individual;
import users.User;
import utils.MyScanner;

public class Menu {

public static void main(String[] args) {
	// αρχικασ να φοα να μην γρτώσω όλη την λίστα μέσα στο manager και τις λίστυες τουες γίονεται το προγραμμα 
	
	
	while(true) {
	System.out.println(Globals.separetor);
	System.out.println(Globals.LoginPrompt);
	 int choice = MyScanner.readInt();
	 
	 if(choice == 4) {
		 System.out.println("EXITING THE PROGRAM");
		 System.exit(0);
	 }
	 
	 
	 
	    System.out.print("Enter Username/VAT: ");
	    String usernameOrVAT =  MyScanner.readString();
	    System.out.print("Enter Password: ");
	    String password = MyScanner.readString();

		 User login = UserManager.getInstance().authenticateAndLogin(usernameOrVAT,password);

		 switch(choice) {
		 
		 case 1:{
			 if(login instanceof Individual) {
				 
				 IndividualCLI.IndividualMenu((Individual)login);
				 
			 }
		 break;}
		 
		 case 2:{
			 if(login instanceof Company) {
				 CompanyCLI.companyMenu((Company) login);
			 }}
		 break;
		 
		 case 3:{
			 if(login instanceof Admin) {
				 AdminCLI.adminMenu((Admin) login);
			 }
		 break;
		 }
		 

	}
}
}
}