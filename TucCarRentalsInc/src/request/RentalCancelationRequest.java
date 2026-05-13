package request;

import java.time.LocalDate;

import Vehicles.Vehicles;
import contracts.Contract;
import managers.ContractManager;
import managers.UserManager;
import storage.UnMarshalingException;
import users.Customer;

public class RentalCancelationRequest extends Request<RentalCancelationRequest> {
	
	

	
	private Customer customer;
	private LocalDate startDate;

private Contract <?,?> contract;
private LocalDate today;

	



	public RentalCancelationRequest(String referenceId,LocalDate timestamp,String type) {
		super(referenceId,timestamp,type);
		
	}
	public RentalCancelationRequest (){}







	private Customer getCustomer() {
	return customer;
}







private void setCustomer(Customer customer) {
	this.customer = customer;
}







private LocalDate getStartDate() {
	return startDate;
}







private void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
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
	
		if(super.requestId == null || super.requestId.isEmpty()) {
			return false;
		}
		else if(contract == null||super.referenceId == null || super.referenceId.isEmpty()) {
			return false;
		}
		else if(super.getTimestamp() == null) {
			return false ;
		}
		else if(customer == null||customer.getVAT() == null || customer.getVAT().isEmpty()) {
			return false;
		}
		
		else if(startDate.isAfter(today)) {
			return false;
		}
		
		Contract<?,?> con = ContractManager.getInstance().findContract(contract.getReferenceId());
		
		if(con == null) {
			return false;
		}
		
		Customer c = UserManager.getInstance().findCustomer(customer.getVAT());
		
		if(c == null) {
			return false;
		}
		
		return true;
	}
}

// mallon tha prepei edo na kanoume mia method find requets by id h opoia tha scanarei ola ta rentalBooking request kai tha epistrefei ayto to request kai tis plhrofories tou 
// alla logika ayto tha ginei ston manager
