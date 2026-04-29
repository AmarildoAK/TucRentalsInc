package Vehicles;

import storage.UnMarshalingException;
import utils.CarPassengerVehicleType;
import utils.CompanyVanCategory;

//import java.time.*;
public class CompanyVan extends Vehicles {

	private String type;
	public CompanyVan(String licensePlate, String catgerory,String transmission,String make,String model,String year,String type) {
		super(licensePlate, catgerory,transmission, make, model, year);
		this.setType(this.getClass().getName());


	private CompanyVanCategory category;
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
	}}
	
	
	
