
package request;

import java.time.LocalDate;

import Vehicles.Vehicles;
import contracts.Contract;
import managers.ContractManager;
import managers.UserManager;
import managers.VehicleManager;
import storage.Storable;
import storage.UnMarshalingException;
import users.Customer;
import utils.CarPassengerVehicleType;
import utils.CompanyVanCategory;

public class RentalBookingRequest extends Request<RentalBookingRequest> { // local date den tha eprepe na eixe ????

	protected LocalDate startDate;
	protected LocalDate endDate;
	private Vehicles vehicle;
	private Customer customer;
private Contract<?,?> contract;
	
	
	public Vehicles getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private CarPassengerVehicleType categ;
	private CompanyVanCategory categoryVan;

	public CarPassengerVehicleType getCateg() {
		return categ;
	}

	public void setCateg(CarPassengerVehicleType categ) {
		this.categ = categ;
	}

	public CompanyVanCategory getCategoryVan() {
		return categoryVan;
	}

	private void setCategoryVan(CompanyVanCategory categoryVan) {
		this.categoryVan = categoryVan;
	}

	public RentalBookingRequest(String referenceId, String requestId, LocalDate timestamp, String type,
			LocalDate startDate, LocalDate endDate, CarPassengerVehicleType categ) {
		super(referenceId, timestamp, type);

	}
	public RentalBookingRequest() {}

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

		if (data == null) {
			throw new UnMarshalingException("Empty Data");
		}

		String[] parts = data.split(",");
		for (String part : parts) {
			String[] keyValue = part.split(":");

			if (keyValue[0].trim().equals("referenceId")) {
				this.referenceId = keyValue[1];
			} else if (keyValue[0].trim().equals("vat")) {
				try {
					this.customer = (Customer) UserManager.getInstance().findCustomer(keyValue[1]);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (keyValue[0].trim().equals("startDate")) {
				this.startDate = LocalDate.parse(keyValue[1]);

			} else if (keyValue[0].trim().equals("endDate")) {
				this.endDate = LocalDate.parse(keyValue[1]);
			} else if (keyValue[0].trim().equals("category")) {
				this.vehicle = (Vehicles) VehicleManager.getInstance().findVehicleByCategory(keyValue[1]);

			}

		}
	}

	@Override
	public int getPriority() {
		int days = 0;

		LocalDate indexDate = this.startDate;

		while (indexDate.isBefore(endDate)) {
			days++;

			indexDate = indexDate.plusDays(1);
		}

		if (days > 0) {
			return days;
		} else {
			return 1;
		}
	}

	@Override
	public boolean isValid() {

		if (super.requestId == null || super.requestId.isEmpty()) {
			return false;
		} else if (contract == null||super.referenceId == null || super.referenceId.isEmpty()) {
			return false;
		} else if (super.getTimestamp() == null) {
			return false;
		} else if (customer == null||customer.getVAT() == null || customer.getVAT().isEmpty()) {

			return false;
		} else if (startDate == null) {

			return false;
		}
		else if(endDate == null) {
			return false;
		}
		else if(vehicle == null||vehicle.getCategory() == null || vehicle.getCategory().isEmpty()) {
			return false;
		}

		Customer c = UserManager.getInstance().findCustomer(customer.getVAT());
		
		if(c == null) {
			return false;
		}
		
	Contract<?,?> con = ContractManager.getInstance().findContract(contract.getReferenceId());
	
	if(con == null) {
		return false;
	}
		
		
		return true;
	}
}
