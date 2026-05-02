package cli;

import utils.MyScanner;

public class Menu {

public static void main(String[] args) {
	// αρχικασ να φοα να μην γρτώσω όλη την λίστα μέσα στο manager και τις λίστυες τουες γίονεται το προγραμμα 
	Admin aCli;
	Company compCli;
	Individual iCli;
	System.out.println(Globals.separetor);
	System.out.println(Globals.LoginPrompt);
	 int choice = MyScanner.readInt();
	switch (choice) {
	case 1: {
		System.out.println("Re-routing to individual menu.......");
		Individual ind;
		
		break;
	}
	case 2:{
		System.out.println("Re-routing to company menu.......");
		Company comp;
		break;
	}
	case 3:{
		System.out.println("Re-routing to admin menu.......");
		break;
	}
	case 4:{
		System.out.println("ΕΞΟΔΟΣ ΑΠΟ ΤΟ ΠΡΟΓΡΑΜΜΑ");
		System.exit(0);
		break;
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + choice);
	}
}
}
