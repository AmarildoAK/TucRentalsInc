package Vehicles;

import storage.UnMarshalingException;
import utils.CarPassengerVehicleType;

//import java.time.Duration;
//import java.time.LocalDate;

public class CarPassanger extends Vehicles {
	private String type = "CarPassanger";
	private CarPassengerVehicleType category;

	public CarPassanger(String licenseplate, String transmission, String make, String model, int year,
			CarPassengerVehicleType category) {
		super(licenseplate, category.name(), transmission, make, model, year);

//		this.expirationDate=expirationDate;
//		this.rentDate=rentDate;

	}

	public CarPassanger() {
	}

	public String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}

	public CarPassengerVehicleType getVehicleCategory() {
		return category;
	}

	private void setVehicleCategory(CarPassengerVehicleType category) {
		this.category = category;
	}

	public String marshal() {

		StringBuffer sb = new StringBuffer(	super.marshal());

	
		
		return sb.toString();
	}

	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);

 
}
	}
