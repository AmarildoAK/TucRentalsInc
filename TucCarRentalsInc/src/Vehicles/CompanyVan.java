package Vehicles;

import storage.UnMarshalingException;

//import java.time.*;
public class CompanyVan extends Vehicles {
	private String type;
	public CompanyVan(String licensePlate, String catgerory,String transmission,String make,String model,String year,String type) {
		super(licensePlate, catgerory,transmission, make, model, year);
		this.setType(this.getClass().getName());
		
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
	
	
	
	//LocalDate rentDate;
	//int timeOfLease; ara ta amaxia kathe fora poy fairnoyme neo car den dinoume hmeeromhnia
	// edo na kano enum gia ton xrono kai na ton peraso mesa tis times ana mera 
	
	
}
