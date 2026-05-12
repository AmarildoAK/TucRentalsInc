package request;

import java.time.LocalDate;

import Vehicles.Vehicles;
import managers.UserManager;
import storage.UnMarshalingException;
import users.Customer;

public class RentalCancelationRequest extends Request<RentalCancelationRequest> {
	
	

	private int  RentalbookingreferencetID;
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private static final int counter = 000;
	private String referenceId;

	public RentalCancelationRequest(String referenceId,LocalDate timestamp,String type) {
		super(referenceId,timestamp,type);
		
		this.referenceId="RCRQ"+counter;
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

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
}

// mallon tha prepei edo na kanoume mia method find requets by id h opoia tha scanarei ola ta rentalBooking request kai tha epistrefei ayto to request kai tis plhrofories tou 
// alla logika ayto tha ginei ston manager
