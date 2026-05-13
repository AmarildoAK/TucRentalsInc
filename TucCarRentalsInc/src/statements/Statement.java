package statements;

import java.time.LocalDate;

import Vehicles.Vehicles;
import managers.TransactionManager;
import storage.Storable;
import storage.UnMarshalingException;
import transaction.Transaction;

public class Statement<T extends Transaction> implements Storable,Comparable<Statement<T>>{

	
	private String creator;
	private T transaction;
	
	public Statement(String creator,T transaction) {
	this.creator = creator;
	this.transaction = transaction;
	}
	 
	
	public Statement(){}

	

	public T getTransaction() {
		return transaction;
	}



	private void setTransaction(T transaction) {
		this.transaction = transaction;
	}



	private String getCreator() {
		return creator;
	}

	private void setCreator(String creator) {
		this.creator = creator;
	}

	
	
	public String marshal() {
		StringBuffer sb = new StringBuffer("type: ").append(this.getClass().getName()).append(";");
		
		
		
		sb.append("creator:").append(this.creator).append(",");
		sb.append("transaction:").append(this.transaction).append(",");
		
		

		return sb.toString();
	}
	
	
public void unmarshal(String data) throws UnMarshalingException {
		
	if(data == null) {
		throw new UnMarshalingException("Empty Data");
		}

		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
			if(keyValue[0].trim().equals("creator")) {
				this.creator = keyValue[1];
			}else if(keyValue[0].trim().equals("transaction")) {
					try {
						this.transaction = (T) TransactionManager.getInstance().findTransaction(keyValue[1]);
					}catch(Exception e ) {
						System.out.println(e.getMessage());
					}
				}
		}
	
	
	
	
}

@Override
public int compareTo(Statement o) {
	// TODO Auto-generated method stub
	return 0;
}

	
	
	
}
