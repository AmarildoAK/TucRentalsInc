package request;

import java.time.LocalDate;

import Vehicles.Vehicles;
import contracts.Contract;
import managers.ContractManager;
import managers.UserManager;
import managers.VehicleManager;
import storage.UnMarshalingException;
import users.Customer;

public class FinePayment extends Request<FinePayment> {

	private static final int counter = 000;
	private String noticeId;
	private String description;
	private LocalDate noticeDate;
	private double amount;
	private Vehicles vehicle;
	private Customer customer;
	private LocalDate today;
	private Contract<?,?> contract;

	
	
	
	private Customer getCustomer() {
		return customer;
	}

	private void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private Contract<?, ?> getContract() {
		return contract;
	}

	private void setContract(Contract<?, ?> contract) {
		this.contract = contract;
	}

	public Vehicles getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}

	public FinePayment(String requestId, LocalDate timestamp, LocalDate noticeDay, String type, double amount,
			String description) {
		super(requestId, timestamp, type);
		this.noticeId = "FRQ" + noticeId;

		this.noticeDate = noticeDay;

	}

	private String getNoticeId() {
		return noticeId;
	}

	private void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	private String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getNoticeDay() {
		return noticeDate;
	}

	private void setNoticeDay(LocalDate noticeDay) {
		this.noticeDate = noticeDay;
	}

	public double getAmount() {
		return amount;
	}

	private void setAmount(double amount) {
		this.amount = amount;
	}

	private static int getCounter() {
		return counter;
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
		sb.append("noticeDate:").append(this.noticeDate).append(",");
		sb.append("noticeId:").append(this.noticeId).append(",");
		sb.append("amount:").append(this.amount).append(",");
		sb.append("description:").append(this.description).append(",");

		return sb.toString();
	}

	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);

		if (data == null) {
			throw new UnMarshalingException("Empty Data");
		}

		String[] parts = data.split(",");
		for (String part : parts) {
			String[] keyValue = part.split(":");

			if (keyValue[0].trim().equals("licenseplate")) {
				this.vehicle = (Vehicles) VehicleManager.getInstance().findVehicle(keyValue[1]);
			} else if (keyValue[1].trim().equals(keyValue[0])) {
				this.noticeDate = LocalDate.parse(keyValue[1]);

			} else if (keyValue[0].trim().equals("noticeId")) {
				this.noticeId = keyValue[1];
			} else if (keyValue[0].trim().equals("amount")) {
				this.amount = Double.parseDouble(keyValue[1]);
			} else if (keyValue[0].trim().equals("description")) {
				this.description = keyValue[1];
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

		if (super.requestId == null || requestId.isEmpty()) {
               return false;
		}
		else if(super.getTimestamp() == null) {
			return false;
		}else if( vehicle == null||vehicle.getLicenseplate() == null || vehicle.getLicenseplate().isEmpty()) {
			return false;
		}else if(noticeDate.isAfter(super.getTimestamp())) {
			return false;
		}
		else if(this.noticeId == null || noticeId.isEmpty()) {
		     return false;
		}
		else if(this.amount<0) {
			return false;
		}else if(this.description == null || this.description.isEmpty()) {
			return false;
		}
		else if(contract == null||super.referenceId == null || referenceId.isEmpty()) {
			return false;
		}

		Vehicles v = VehicleManager.getInstance().findVehicle(vehicle.getLicenseplate());
		
		if(v== null) {
			return false;
		}
		
		Contract<?,?> con = ContractManager.getInstance().findContract(contract.getReferenceId());
		
		if(con == null) {
			return false;
		}
		
		return true;
	}

}
