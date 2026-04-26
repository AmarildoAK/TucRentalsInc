package User;

import java.util.ArrayList;
import java.util.List;

import contracts.Contract;
import storage.UnMarshalingException;
import transaction.Wallet;

public class Individual  extends Customer{

	private Wallet wallet;

	
	public Individual(int VAT,String firstName,String lastName,String email,String password,String username) {
		super(VAT,firstName,lastName,email,password,username);
	
	}


	
	@Override
	public String marshal() {
	
		StringBuffer sb = new StringBuffer(super.marshal());
		
		return sb.toString();
	}

	@Override
	public void unmarshal(String data) throws UnMarshalingException {
	super.unmarshal(data);
	}
	
	
}
