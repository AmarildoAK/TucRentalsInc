package Vehicles;

import storage.UnMarshalingException;

//import java.time.Duration;
//import java.time.LocalDate;


public class CarPassanger extends Vehicles {
	private String type;


	
//	private LocalDate rentDate;
//	private LocalDate expirationDate;// να τα περασω και σαν ορισματα μέσα στον constructor
//	private long days;
public CarPassanger(String licensePlate, String catgerory,String transmission,String make,String model,String year, String type) {
		super(licensePlate, catgerory,transmission, make, model, year);
		this.type=type.getClass().getName();
//		this.expirationDate=expirationDate;
//		this.rentDate=rentDate;
			}


public String marshal() {
	
	StringBuffer sb = new StringBuffer(super.marshal());
	
	return sb.toString();
}


public void unmarshal(String data) throws UnMarshalingException {
	super.unmarshal(data);
	}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}






//Duration duration =Duration.between(rentDate, expirationDate);
//days=duration.toDays();



// αυτα λογικα θα τα διαβαζουμε μέσα απο τα files που είδη έχουμε
//edo na kano enum gia ton xrono kai na ton peraso mesa tis times ana mera 
}
