package request;

import java.time.LocalDate;

import Vehicles.Vehicles;
import managers.UserManager;
import storage.UnMarshalingException;
import users.Customer;

public class RentalReturn extends Request<Vehicles,Customer>{
	

	private String referenceId;
	
	public RentalReturn(String referenceId, LocalDate timestamp,String type) {
		super(referenceId, timestamp,type);
		
		
	}
	@Override
	public int compareTo(Request o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String marshal() {
		 StringBuffer sb = new StringBuffer(super.marshal());
		 
		 sb.append("referenceId").append(this.referenceId).append(",");
		 sb.append("vat").append(this.customer.getVAT()).append(",");
		 
		 
		return sb.toString();
	}
	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);

        if(data == null) {
            throw new UnMarshalingException("Empty Data");
            }


        String[] parts = data.split(",");
        for (String part : parts) {
            String[] keyValue = part.split(":");

            if(keyValue[0].trim().equals("referenceId")) {
            	this.referenceId = keyValue[1];
            }else if(keyValue[0].trim().equals("vat")) {
            	try {
            	
            		this.customer = (Customer)UserManager.getInstance().findCustomer(keyValue[1]);
            	}catch(Exception e) {
            		System.out.println(e.getMessage());
            	}
            	}
            	
            
        }
	}
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}
   
	
	
}
