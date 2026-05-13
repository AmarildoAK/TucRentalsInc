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
		StatementManager.getInstance().loadStatement();
	}
	
	public static void saveApp() {
		
		ContractManager.getInstance().saveContract();
		UserManager.getInstance().saveUser();
		VehicleManager.getInstance().saveVehicle();
		StatementManager.getInstance().saveStatement();
		
	}
	
	
	
	
	
public static void main(String[] args) {
	// αρχικασ να φοα να μην γρτώσω όλη την λίστα μέσα στο manager και τις λίστυες τουες γίονεται το προγραμμα 
	
	initApp();
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
				 saveApp();
			 }
		 break;}
		 
		 case 2:{
			 if(login instanceof Company) {
				 CompanyCLI.companyMenu((Company) login);
				 saveApp();
			 
			 }}
		 break;
		 
		 case 3:{
			 if(login instanceof Admin) {
				 AdminCLI.adminMenu((Admin) login);
				 saveApp();
			 }
		 break;
		 }
		 

	}
}
}
}