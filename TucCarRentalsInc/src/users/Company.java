package users;

import storage.UnMarshalingException;

public class Company extends Customer {

	private String companyName;
	private String type = "Company";
	
	
	public Company(String VAT,String name,String password,String companyName) {
		super(VAT,name,password);
		if(CheckCompanyName(companyName)) {
		this.companyName = companyName;
		}
		}

	private String getCompanyName() {
		return companyName;
	}

	
	private boolean CheckCompanyName(String companyName) {
		return this.companyName !=null && !this.companyName.trim().isEmpty();
	}
	
	private void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	
	@Override
	public String marshal() {
	
		StringBuffer sb = new StringBuffer(super.marshal());
		
		sb.append("companyName:").append(this.companyName).append(",");
		sb.append("type:").append(this.type).append(",");
		
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
	}else if(keyValue[0].trim().equals("type")) {
		this.type = keyValue[1];
	}
	
	
	}
}

	
}
