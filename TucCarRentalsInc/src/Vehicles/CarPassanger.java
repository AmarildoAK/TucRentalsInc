package Vehicles;

import storage.UnMarshalingException;
import utils.CarPassengerVehicleType;

//import java.time.Duration;
//import java.time.LocalDate;


public class CarPassanger extends Vehicles {
//	private LocalDate rentDate;
//	private LocalDate expirationDate;// να τα περασω και σαν ορισματα μέσα στον constructor
//	private long days;
private CarPassengerVehicleType category;
	
	public CarPassanger(String licensePlate,String transmission,CarPassengerVehicleType category) {
		super(licensePlate,transmission,category.name());
//		this.expirationDate=expirationDate;
//		this.rentDate=rentDate;
			this.category = category;
	}


private CarPassengerVehicleType getCategory() {
		return category;
	}


	private void setCategory(CarPassengerVehicleType category) {
		this.category = category;
	}


public String marshal() {
	
	StringBuffer sb = new StringBuffer(super.marshal());
	return sb.toString();
}


public void unmarshal(String data) throws UnMarshalingException {
	super.unmarshal(data);
}





//Duration duration =Duration.between(rentDate, expirationDate);
//days=duration.toDays();



// αυτα λογικα θα τα διαβαζουμε μέσα απο τα files που είδη έχουμε
//edo na kano enum gia ton xrono kai na ton peraso mesa tis times ana mera 
}


