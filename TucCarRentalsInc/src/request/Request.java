package request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import Vehicles.Vehicles;
import managers.UserManager;
import managers.VehicleManager;
import storage.Storable;
import storage.UnMarshalingException;
import users.Customer;

public abstract class Request<R extends Request<R>> implements Storable,Comparable<Request<R>>{

	
	protected String referenceId;
	
	private LocalDate requestDay;

private String type;
private String requestId;
private LocalDate timestamp;

	
	public Request(String referenceId,LocalDate timestamp,String type) {
		this.referenceId = referenceId;
		this.timestamp=timestamp;
	

	}
	
//	public V getVehicle() {
//		return vehicle;
//	}
//
//	private void setVehicle(V vehicle) {
//		this.vehicle = vehicle;
//	}
//
//	public C getCustomer() {
//		return customer;
//	}
//
//	private void setCustomer(C customer) {
//		this.customer = customer;
//	}

	public String getReferenceId() {
		return referenceId;
	}

	private void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	private LocalDate setTimestamp(LocalDate timestamp) {
		return this.timestamp = timestamp;
	}



	
	public abstract int getPriority();
	public abstract boolean isValid();
		
@Override
public int compareTo(Request<R> other) {

	int comparison = Integer.compare(getPriority(), other.getPriority());
	
	if(comparison == 0) {
		return this.timestamp.compareTo(other.timestamp);
	}
	return comparison;
}

@Override
public String marshal() {
	StringBuffer sb = new StringBuffer("type:").append(this.getClass().getName()).append(",");
	sb.append("type").append(this.type).append(",");
	sb.append("requestId").append(this.requestId).append(",");
	sb.append("timestamp").append(this.timestamp).append(",");
	
	
	
	
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
		}
		else if(keyValue[0].trim().equals("timestamp")) {
			this.timestamp = LocalDate.parse(keyValue[1]);
		}

		
		
	}
}

}