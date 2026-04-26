package Vehicles;

import storage.UnMarshalingException;

//import java.time.*;
public class CompanyVan extends Vehicles {

	public CompanyVan(String licensePlate, String catgerory,String transmission) {
		super(licensePlate, catgerory,transmission);
		
	}
	
	
	
	public String marshal() {
		
		StringBuffer sb = new StringBuffer(super.marshal());
		
		return sb.toString();
	}
	
	
	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);
		}
	
	
	
	//LocalDate rentDate;
	//int timeOfLease; ara ta amaxia kathe fora poy fairnoyme neo car den dinoume hmeeromhnia
	// edo na kano enum gia ton xrono kai na ton peraso mesa tis times ana mera 
	
	
}
