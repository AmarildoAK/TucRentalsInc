package User;

import storage.UnMarshalingException;

public class Company extends Customer {

	private String companyName;
	
	public Company(int VAT,String firstName,String lastName,String email,String password,String companyName,String username) {
		super(VAT,firstName,lastName,email,password,username);
		this.companyName = companyName;
	}

	private String getCompanyName() {
		return companyName;
	}

	private void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	
	@Override
	public String marshal() {
	
		StringBuffer sb = new StringBuffer(super.marshal());
		
		sb.append("companyName").append(this.companyName).append(",");

		return sb.toString();
	}
	
	@Override
	public void unmarshal(String data) throws UnMarshalingException {
	super.unmarshal(data);
	
	String[] parts = data.split(",");
	for(String part: parts) {
		String[] keyValue = part.split(":");
	if(keyValue[0].trim().equals("companyName")) {
		this.companyName = keyValue[1];
	}
	
	
	}
}

	@Override
	public int compareTo(user o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
