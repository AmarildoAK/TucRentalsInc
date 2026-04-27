package managers;





import statements.Statement;
import storage.StorableList;
import storage.StorageManager;
import transaction.Wallet;

public class StatementManager {
private StorableList<Statement> statementList;
	private Wallet s;
	
	
	
	public StatementManager() {
		this.statementList = new StorableList<>();
		
		
	}

	private StorableList<Statement> getStatementList() {
		return statementList;
	}

	private void setStatementList(StorableList<Statement> statementList) {
		this.statementList = statementList;
	}
	
	public Statement findStatement(int NoticeID) {
		for(int i=0;i<statementList.size();i++) {
			if(statementList.get(i).getNoticeID() == NoticeID) {
				return statementList.get(i);
			}
		
		}
		return null;
	}
	
	
	
	public boolean CreateStatement(Statement newStatement,int VAT) {
		if(findStatement(newStatement.getNoticeID())!=null) {
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
	
	
	public void RetrieveStatements(int VAT) { // den eimai kai poly sigouros gia to int VAT
		
		try {
			StorageManager.getInstance().loadObject(this.statementList,"Data/statements/statement.csv" );
		System.out.println("The statement has been retrieved succesfully");
		}catch(Exception e){
			System.out.println("The statement has met an error while retrieving it "+e.getMessage());
		}
		
		
	}
	
}
