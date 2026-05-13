package users;

import java.util.ArrayList;
import java.util.List;

import contracts.Contract;
import storage.UnMarshalingException;
import transaction.Wallet;

public class Individual  extends Customer{

	private String type = "Individual";

	
	public Individual(String VAT,String name,String password) {
		super(VAT,name,password);
	
	}
	public Individual() {}


	
	@Override
	public String marshal() {
	
		StringBuffer sb = new StringBuffer(super.marshal());
		sb.append("type:").append(this.type).append(",");
		
		return sb.toString();
	}

	@Override
	public void unmarshal(String data) throws UnMarshalingException {
	super.unmarshal(data);
	
	if(data == null) {
		throw new UnMarshalingException("Empty Data");
		}

		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
			if(keyValue[0].trim().equals("type")) { 
				this.type = keyValue[1];
		}
		}
	}



	
	
}
