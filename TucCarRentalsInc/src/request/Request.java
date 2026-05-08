package request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import Vehicles.Vehicles;
import managers.UserManager;
import managers.VehicleManager;
import storage.Storable;
import storage.UnMarshalingException;
import users.Customer;

public abstract class Request<V extends Vehicles,C extends Customer> implements Storable,Comparable<Request>{

	
	private String referenceId;
	protected String status;
	private LocalDate requestDay;
	protected V vehicle;
	protected C customer;
private String type;
private String requestId;
private LocalDate timestamp;
private LocalDate startDate;
private LocalDate endDate;
	
// marshal kai unmarshal sto request !!!!!

	


	private String getStatus() {
		return status;
	}



	private void setStatus(String status) {
		this.status = status;
	}



	public String getReferenceId() {
		return referenceId;
	}

	
	

	public Request(String referenceId,LocalDate timestamp,String status) {
		this.referenceId = referenceId;
		this.timestamp=timestamp;
		this.status=status;

	}
	


	private void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	private LocalDate getTimestamp() {
		return timestamp;
	}

	private LocalDate setTimestamp(LocalDate timestamp) {
		return this.timestamp = timestamp;
	}



@Override
public int compareTo(Request other) {
	return this.requestDay.compareTo(other.requestDay);
	
}

@Override
public String marshal() {
	StringBuffer sb = new StringBuffer("type:").append(this.getClass().getName()).append(",");
	sb.append("type").append(this.type).append(",");
	sb.append("requestId").append(this.requestId).append(",");
	sb.append("referenceId").append(this.referenceId).append(",");
	sb.append("timestamp").append(this.timestamp).append(",");
	sb.append("vat").append(this.customer.getVAT()).append(",");
	sb.append("startDate").append(this.startDate).append(",");
	sb.append("endDate").append(this.endDate).append(",");
	sb.append("category").append(this.vehicle.getCategory()).append(",");
	
	return sb.toString();
}

@Override
public void unmarshal(String data) throws UnMarshalingException {
	
	if (data == null) {
		throw new UnMarshalingException("Empty Data");
	}
	
	String[] parts = data.split(",");
	for (String part : parts) {
		String[] keyValue = part.split(":");

		if(keyValue[0].trim().equals("type")) {
			this.type = keyValue[1];
		}else if(keyValue[0].trim().equals("requestId")) {
			this.requestId = keyValue[1];
		}else if(keyValue[0].trim().equals("referenceId")) {
			this.referenceId = keyValue[1];
		}else if(keyValue[0].trim().equals("timestamp")) {
			this.timestamp = LocalDate.parse(keyValue[1]);
		}else if(keyValue[0].trim().equals("vat")) {
			try {
				this.customer = (C)UserManager.getInstance().findCustomer(keyValue[1]);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}else if(keyValue[0].trim().equals("startDate")) {
			this.startDate = LocalDate.parse(keyValue[1]);
		}else if(keyValue[0].trim().equals("endDate")) {
			this.endDate = LocalDate.parse(keyValue[1]);
		}else if(keyValue[0].trim().equals("category")) {
			try {
				this.vehicle = (V) VehicleManager.getInstance().findVehicleByCategory(keyValue[1]);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
}

}