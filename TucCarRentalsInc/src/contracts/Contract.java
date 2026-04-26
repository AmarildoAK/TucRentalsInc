package contracts;

import java.time.LocalDate;

import Vehicles.Vehicles;
import storage.Storable;
import storage.UnMarshalingException;


public abstract class Contract implements Storable,Comparable<Contract> {

	private String status;
	private int contractID;
	private static int contractIDcounter=1;
	private Vehicles rentedCar;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	public Contract(String status,int contractID) {
		this.status = "ACTIVE";
	this.contractID = contractIDcounter++;
	this.rentedCar = rentedCar;
	}

	public String getStatus() {
		return status;
	}


	public String setStatus(String status) {
		return this.status = status;
	}
	
	
	
	
	public int getContractID() {
		return contractID;
	}




	private void setContractID(int contractID) {
		this.contractID = contractID;
	}




	public Vehicles getRentedCar() {
		return rentedCar;
	}




	private void setRentedCar(Vehicles rentedCar) {
		this.rentedCar = rentedCar;
	}


	public LocalDate getStartDate() {
		return startDate;
	}

	private void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public  LocalDate getEndDate() {
		return endDate;
	}

	private void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	
	@Override
	public int compareTo(Contract other) {
		return this.getContractID() - other.contractID;
	}




	@Override
	public String marshal() {
		StringBuffer sb = new StringBuffer("type: ").append(this.getClass().getName()).append(";");

		sb.append("Status").append(this.status).append(",");
		sb.append("ContractID").append(this.contractID).append(",");

		return sb.toString();

	}



	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		
		if(data == null) {
			throw new UnMarshalingException("Empty Data");
			}
		
		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
			if(keyValue[0].trim().equals("Status")) {
				this.status = keyValue[1];
			}else if(keyValue[0].trim().equals("ContractID")) {
				this.contractID = Integer.parseInt(keyValue[1]);
			
		}
	}
}







}