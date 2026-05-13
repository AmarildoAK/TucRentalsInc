package managers;





import java.io.File;
import java.util.Iterator;

import statements.Statement;
import storage.StorableList;
import storage.StorageManager;
import transaction.Wallet;

public class StatementManager {
	
	
	public static StatementManager instance;
	
	public static StatementManager getInstance() {
		if(instance == null) {
			instance = new StatementManager();
		}
	return instance;
	}
	
	
	
	
public StorableList<Statement<?>> getStatementsForUser(String VAT){
	File file = new File("Data/statements"+VAT+"_statements.csv");
	StorableList<Statement<?>>  userStatements = new StorableList<Statement<?>>();

	try {
		StorageManager.getInstance().loadObject(userStatements, "Data/statements"+VAT+"_statements.csv");// na kano metablhth filename pou tha kaloume edo??
	} catch (Exception e) {
		System.out.println("Error loading the file");
		
		// TODO: handle exception
	}
	return userStatements;
}

public void createStatement(Statement<?> snew,String Vat) {
	StorableList<Statement<?>> userStatements = getStatementsForUser(Vat);
	for(Statement<?> s: userStatements) {
		if (s.getTransaction().getTransactionID()==snew.getTransaction().getTransactionID()) {
			System.out.println("The statement is already in the list ");
		}
		
	}
	userStatements.add(snew);

	String filename ="Data/statements"+Vat+"_statements.csv";
	try {
		StorageManager.getInstance().storeObject(userStatements, filename);
	} catch (Exception e) {
		System.out.println("ERRORRRRRR");
	}
	
}


public String getAllUserStatements(String Vat) {
	String  printable="";
	StorableList<Statement<?>> userStatements = getStatementsForUser(Vat);
	for(Statement s: userStatements) {
		printable+=s.toString();
		
	}
	return printable;
}


}
