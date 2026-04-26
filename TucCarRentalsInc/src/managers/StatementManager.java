package managers;



import storage.StorableList;
import storage.StorageManager;
import transaction.Wallet;

public class StatementManager {
private StorableList<Wallet> statementList;
	private Wallet s;
	
	
	
	public StatementManager() {
		this.statementList = new StorableList<>();
		
		
	}

	private StorableList<Wallet> getStatementList() {
		return statementList;
	}

	private void setStatementList(StorableList<Wallet> statementList) {
		this.statementList = statementList;
	}
	
	public Wallet findWallet(int WalletID) {
		for(int i=0;i<statementList.size();i++) {
			if(statementList.get(i).getWalletID() == WalletID) {
				return statementList.get(i);
			}
		
		}
		return null;
	}
	
	
	
	public boolean CreateStatement(Wallet newStatement) {
		if(findWallet(s.getWalletID())!=null) {
			return false;
		}else {
			statementList.add(newStatement);
			try {
				StorageManager.getInstance().storeObject(statementList,"Data/statements/statement.csv"); // se poio arxeio tha prepei na ginei h apotikeush 
			System.out.println("The statement has been stored succesfully");
			
			}catch(Exception e) {
				System.out.println("There has been an error storing the statement"+e.getMessage());
			}
			return true;
		}
	}
	
	
	public void RetrieveStatements() {
		
		try {
			StorageManager.getInstance().loadObject(this.statementList,"Data/statements/statement.csv" );
		System.out.println("The statement has been retrieved succesfully");
		}catch(Exception e){
			System.out.println("The statement has met an error while retrieving it "+e.getMessage());
		}
		
		
	}
	
}
