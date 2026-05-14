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

		StringBuffer sb = new StringBuffer(super.marshal());

		sb.append("type:").append(this.type).append(",");
		return sb.toString();
	}

	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);

//		if (data == null) {
//			throw new UnMarshalingException("Empty Data");
//		}
//
//		String[] parts = data.split(",");
//		for (String part : parts) {
//			String[] keyValue = part.split(":");
//
//			if (keyValue[0].trim().equals("type")) {
//				this.type = keyValue[1];
//			}
//
//		}
//	}

//Duration duration =Duration.between(rentDate, expirationDate);
//days=duration.toDays();

// αυτα λογικα θα τα διαβαζουμε μέσα απο τα files που είδη έχουμε
//edo na kano enum gia ton xrono kai na ton peraso mesa tis times ana mera 
}}
