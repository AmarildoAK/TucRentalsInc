	package cli;

import utils.MyScanner;

public class Admin {
	
public void adminMenu() {
System.out.println(Globals.separetor);
System.out.println(Globals.AdminPrompt);
int choice = MyScanner.nextInt();

// kapou edo prepei na elegxw to login toy xrhsth
//Επίσης στο cli λογικά δεν πρέπει να βάλουμε και άλλο ένα switchcase που θα ξεχωρίζει το login με το register??
switch (choice) {
case 1: {
	
	System.out.println("Loading the vehicle fleet......");// na ftiajoyme mia methodo printVehivcles που θα τυπωνει τον στόλο και να την καλέσουμε 
	break;
}
case 2:{
	System.out.println("Loading customers details.......");// ή θέλει για ένα μόνο πελάτη σε αυτή την περίπτωση
System.out.println("Give me the VAT of the customer...");
//kaloume thn methodo find customer by VAT ή καλούμε τον κατάλληλο manager  dld logika twn user manager
System.out.println("Here are the details for the customer");
	break;
}
case 3:{
	System.out.println("Staring the time simulation ");// ωραία άρα εδώ απλ΄ατο καλούμαι και έπειτα μέσα στην μέθοδο time passing ρωτάμε τονuser μέσα στο request processor
	break;
}
case 4:{
	System.out.println("ΕΞΟΔΟΣ ΑΠΟ ΤΟ ΠΡΟΓΡΑΜΜΑ");
	System.exit(0);
	break;
}
case 5:{
	System.out.println("test the gitHUb");
	break;
}
		
		
		}
}
}
