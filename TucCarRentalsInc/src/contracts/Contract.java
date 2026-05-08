package contracts;

import java.time.LocalDate;

import Vehicles.Vehicles;
import managers.UserManager;
import managers.VehicleManager;
import storage.Storable;
import storage.UnMarshalingException;
import users.Customer;

public abstract class Contract<V extends Vehicles, C extends Customer> implements Storable, Comparable<Contract<V, C>> {

	private String status;
	private String contractID;// mas eipame na to kanoyme string alla an to kanoume String πως θα το αυξάνουμε
    private String refernceId;
	
    private V car;
	private C customer;

	private LocalDate startDate;
	private LocalDate endDate;

	public Contract(C customer,V vehicle,String referenceId,LocalDate startDate,LocalDate endDate) {
		this.status = "ACTIVE";
this.refernceId = referenceId;
	}

	
	
	
	




	public String getReferenceId() {
		return refernceId;
	}




	private void setReferenceId(String refernceId) {
		this.refernceId = refernceId;
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
	public V getCar() {
	    return car;
	}


//	@Override
//	public int compareTo(Contract other) {
//		return this.getContractID() - other.contractID;
//	} NA ALAJOYME TO OVERRRIDE 

	@Override
	public String marshal() {
		StringBuffer sb = new StringBuffer("type:").append(this.getClass().getName()).append(",");

		sb.append("Status:").append(this.status).append(",");
		sb.append("referenceId:").append(this.refernceId).append(",");
		sb.append("endDate:").append(this.endDate).append(",");
		sb.append("startDate:").append(this.startDate).append(",");
		sb.append("licenseplate:").append(this.car.getLicenseplate()).append(",");
        sb.append("VAT:").append(this.customer.getVAT()).append(",");
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

			if (keyValue[0].trim().equals("Status")) {
				this.status = keyValue[1];
			} else if (keyValue[0].trim().equals("referenceId")) {
				this.refernceId = keyValue[1];

			}
			else if (keyValue[0].trim().equals("licenseplate")) {
				try {

					this.car = (V) VehicleManager.getInstance().findVehicle(keyValue[1]);
				} catch (Exception e) {
					System.out.println("The vehicle has not been found");
				}
			} else if (keyValue[0].trim().equals("startDate")) {
				this.startDate = LocalDate.parse(keyValue[1]);
			} else if (keyValue[0].trim().equals("endDate")) {
				this.endDate = LocalDate.parse(keyValue[1]);
			}
			else if (keyValue[0].trim().equals("VAT")) {
				try {
				this.customer = (C) UserManager.getInstance().findCustomer(keyValue[1]);
				}catch(Exception e) {
					System.out.println("User vat has not been allocated");
				}
			}

		}
	}

}