package cli;

public class Globals {

	public static final String separetor = "=============================================================";
	
	public static final String LoginPrompt = "Choose your login option:\n"
            +"Type 1 to login as an individual user\n"
            +"Type 2 to login as a company user\n"
            +"Type 3 to login as an admin\n"
            +"Type 4 to quit\n";
	
	
	public static final String IndividualPrompt = 
	                                        "Type 1 to Overview\n"
			                                +"Type 2 to Pay Balance\n"
	                                        +"Type 3 to see the Transaction History\n"
			                                +"Type 4 to quit\n";
	
	
	           
	public static final String CompanyPrompt = "Type 1 to Overview\n"
	                                           +"Type 2 to Pay Balance\n"
			                                   +"Type 3 to see active lease contracts\n"
	                                           +"Type 4 to Quit\n";
	
	
	public static final String AdminPrompt = "Type 1 to see the fleet(Vehicles)\n"
			                                 +"Type 2 to see Customers information\n"
			                                 +"Type 3 to simulate time passing\n"
			                                 +"Type 4 to Quit";
	
	
	public static final String CustomerAdminSubMenu = "Type 1 to see the list of Customers"+
	                                                  "Type 2 to show Balance of users"+
			                                          "Type 3 to search for wallet statement of a user"
			                                          +"Type 0 to quit of the sub Menu";
	
}
