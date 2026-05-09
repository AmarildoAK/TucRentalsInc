package request;

import java.time.LocalDate;

import Vehicles.Vehicles;
import managers.UserManager;
import managers.VehicleManager;
import storage.UnMarshalingException;
import users.Customer;

public class FinePayment extends Request<Vehicles,Customer>{

	private static final int counter = 000;
	private String noticeId;
    private String description;
	private LocalDate noticeDay;
private double amount;
	
	public FinePayment(String requestId, LocalDate timestamp,LocalDate noticeDay,String type,double amount,String description) {
		super(requestId, timestamp,type);
		this.noticeId="FRQ"+noticeId;
	
	this.noticeDay = noticeDay;
	
	}


	@Override
	public int compareTo(Request o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String marshal() {
		StringBuffer sb = new StringBuffer(super.marshal());
		
		sb.append("licenseplate:").append(this.vehicle.getLicenseplate()).append(",");
		sb.append("noticeDate:").append(this.noticeDay).append(",");
		sb.append("noticeId:").append(this.noticeId).append(",");
		sb.append("amount:").append(this.amount).append(",");
		sb.append("description:").append(this.description).append(",");
		
		
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

            if(keyValue[0].trim().equals("licenseplate")) {
            	this.vehicle = (Vehicles)VehicleManager.getInstance().findVehicle(keyValue[1]);
            }
            else if(keyValue[1].trim().equals(keyValue[0])) {
            	this.noticeDay = LocalDate.parse(keyValue[1]);
            	
            }
            else if(keyValue[0].trim().equals("noticeId")) {
            	this.noticeId = keyValue[1];
            }
            else if(keyValue[0].trim().equals("amount")) {
            	this.amount = Double.parseDouble(keyValue[1]);
            }
            else if(keyValue[0].trim().equals("description")) {
            	this.description = keyValue[1];
            }
            
        }
		
	}


	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
	
	
	
	
}
