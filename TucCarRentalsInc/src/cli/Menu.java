package cli;

import managers.ContractManager;
import managers.StatementManager;
import managers.UserManager;
import managers.VehicleManager;
import users.Admin;
import users.Company;
import users.Individual;
import users.User;
import utils.MyScanner;

public class Menu {

	
	public static void initApp() {
		
		ContractManager.getInstance().loadContract();
		UserManager.getInstance().loadUsers();
	VehicleManager.getInstance().loadVehicle();
		
}
	
	public static void saveApp() {
		
		ContractManager.getInstance().saveContract();
		UserManager.getInstance().saveUser();
		VehicleManager.getInstance().saveVehicle();
		
		
	}
	
	
	
	
	
public static void main(String[] args) {
	// αρχικασ να φοα να μην γρτώσω όλη την λίστα μέσα στο manager και τις λίστυες τουες γίονεται το προγραμμα 
	
	initApp();
	System.out.println("Χρήστες που φορτώθηκαν: " + UserManager.getInstance().AllCustomerList());
	while(true) {
	System.out.println(Globals.separetor);
	System.out.println(Globals.LoginPrompt);
	 int choice = MyScanner.readInt();
	 
	 if(choice == 4) {
		 System.out.println("EXITING THE PROGRAM");
		 saveApp();
		 System.exit(0);
	 }
	 
	 
	 
	    System.out.print("Enter Username/VAT: ");
	    String usernameOrVAT =  MyScanner.readString();
	    System.out.print("Enter Password: ");
	    String password = MyScanner.readString();

		 User login = UserManager.getInstance().authenticateAndLogin(usernameOrVAT,password);

		 if(login == null) {
			 System.out.println("Login failed");
	 continue;
		 }
		 
		 
		 switch(choice) {
		 
		 case 1:{
			 if(login instanceof Individual) {
				 
				 IndividualCLI.IndividualMenu((Individual)login);
				 
			 }else {
				 System.out.println("login as an individual failed");
			 }
		
			 
			 break;
			 
		 }
		 
		 case 2:{
			 if(login instanceof Company) {
				 CompanyCLI.companyMenu((Company) login);
				 
			 
			 }else {
				 System.out.println("login as an company failed");
			 }
			 break;
		 }
		
		 
		 case 3:{
			 if(login instanceof Admin) {
				 AdminCLI.adminMenu((Admin) login);
				 
			 }else {
				 System.out.println("login as an Admin failed");
			 }
		 break;
		 }
		 

	}
}
}
}