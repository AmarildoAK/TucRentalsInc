package request;

import java.time.LocalDate;

import Vehicles.Vehicles;
import managers.UserManager;
import managers.VehicleManager;
import storage.Storable;
import storage.UnMarshalingException;
import users.Customer;

public class RentalBookingRequest extends Request<Vehicles,Customer> { // local date den tha eprepe na eixe ????

	
	private static final int counter = 000; // auto to theloume ???? 
	private String referenceId;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	public RentalBookingRequest(String referenceId,String requestId,LocalDate timestamp,String type,LocalDate startDate,LocalDate endDate) {
		super(referenceId,timestamp,type);
	    this.referenceId="RBRQ"+ counter;
	}

	
	
	
	
	public String getReferenceId() {
		return referenceId;
	}





	private void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}





	public LocalDate getStartDate() {
		return startDate;
	}





	private void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}





	public LocalDate getEndDate() {
		return endDate;
	}





	private void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}





	@Override
	public int compareTo(Request o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String marshal() {
		 StringBuffer sb = new StringBuffer(super.marshal());
		
		sb.append("referneceId").append(this.referenceId).append(",");
		sb.append("vat").append(this.customer.getVAT()).append(",");
		sb.append("startDate").append(this.startDate).append(",");
		sb.append("endDate").append(this.endDate).append(",");
		sb.append("category").append(this.vehicle.getCategory()).append(",");
		
		
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
    			}catch(Exception e ) {
    				System.out.println(e.getMessage());
    			}
            }else if(keyValue[0].trim().equals("startDate")) {
            	this.startDate = LocalDate.parse(keyValue[1]);
            
            }
            else if(keyValue[0].trim().equals("endDate")) {
            	this.endDate = LocalDate.parse(keyValue[1]);
            }else if(keyValue[0].trim().equals("category")) {
            	this.vehicle = (Vehicles) VehicleManager.getInstance().findVehicleByCategory(keyValue[1]);
            			
            }
        
        }
	}
	
}
