package users;

import storage.UnMarshalingException;

public class Company extends Customer {

	private String representative;
	private String type = "Company";
	
	
	public Company(String VAT,String name,String password,String companyName) {
		super(VAT,name,password);
		if(CheckCompanyName(companyName)) {
		this.representative = companyName;
		}
		}
	public Company() {}

	private String getCompanyName() {
		return representative;
	}

	
	private boolean CheckCompanyName(String companyName) {
		return this.representative !=null && !this.representative.trim().isEmpty();
	}
	
	private void setCompanyName(String companyName) {
		this.representative = companyName;
	}

	
	
	@Override
	public String marshal() {
	
		StringBuffer sb = new StringBuffer(super.marshal());
		
		sb.append("representative:").append(this.representative).append(",");
		sb.append("type:").append(this.type).append(",");
		
		return sb.toString();
	}
	
	@Override
	public void unmarshal(String data) throws UnMarshalingException {
	super.unmarshal(data);
	
	String[] parts = data.split(",");
	for(String part: parts) {
		String[] keyValue = part.split(":");
	if(keyValue[0].trim().equals("representative")) {
		this.representative = keyValue[1];
	}else if(keyValue[0].trim().equals("type")) {
		this.type = keyValue[1];
	}
	
	
	}
}

	
}
