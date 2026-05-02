package contracts;

import java.time.LocalDate;

import Vehicles.Vehicles;
import storage.Storable;
import storage.UnMarshalingException;


public abstract class Contract implements Storable,Comparable<Contract> {

	private String status;
	private String contractID;// mas eipame na to kanoyme string alla an to kanoume String πως θα το αυξάνουμε
	private static int contractIDcounter=1;
	private Vehicles rentedCar;
	private LocalDate startDate;
	private LocalDate endDate;
	private String tempPlate;
	
	public Contract(String status,int contractID,Vehicles rentedCar) {
		this.status = "ACTIVE";
	this.contractID = "CID"+contractIDcounter++;
	this.rentedCar = rentedCar;
	
	}

	
	
	private String getTempPlate() {
		return tempPlate;
	}



	private void setTempPlate(String tempPlate) {
		this.tempPlate = tempPlate;
	}



	public String getStatus() {
		return status;
	}


	public String setStatus(String status) {
		return this.status = status;
	}
	
	
	
	
	public String getContractID() {
		return contractID;
	}




	private void setContractID(String contractID) {
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

	
//	@Override
//	public int compareTo(Contract other) {
//		return this.getContractID() - other.contractID;
//	} NA ALAJOYME TO OVERRRIDE 




	@Override
	public String marshal() {
		StringBuffer sb = new StringBuffer("type:").append(this.getClass().getName()).append(",");

		sb.append("Status:").append(this.status).append(",");
		sb.append("ContractID:").append(this.contractID).append(",");
		sb.append("endDate:").append(this.endDate).append(",");
		sb.append("startDate:").append(this.startDate).append(",");
		sb.append("rentedCar:").append(this.rentedCar.getLicenseplate()).append(",");

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
				this.contractID = keyValue[1];
			
//			if(contractID >= contractIDcounter) {
//				contractIDcounter = contractID + 1 ;
//			}
//			WTF IS THAT TI ΕΛΕΓΧΕΙ ΑΥΤΟ?
			}
			else if(keyValue[0].trim().equals("rentedCar")) {
				this.tempPlate = keyValue[1];
			}
			else if(keyValue[0].trim().equals("startDate")) {
				this.startDate = LocalDate.parse(keyValue[1]);
			}
			else if(keyValue[0].trim().equals("endDate")) {
				this.endDate = LocalDate.parse(keyValue[1]);
			}
		
		
		}
}







}