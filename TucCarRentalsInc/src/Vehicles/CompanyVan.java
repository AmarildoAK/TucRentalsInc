package Vehicles;

import storage.UnMarshalingException;
import utils.CarPassengerVehicleType;
import utils.CompanyVanCategory;

//import java.time.*;
public class CompanyVan extends Vehicles {

	private CompanyVanCategory category;

	public CompanyVan(String licensePlate, String transmission, CompanyVanCategory category) {
		super(licensePlate, transmission, category.name());

	}

	public String marshal() {

		StringBuffer sb = new StringBuffer(super.marshal());
		
		return sb.toString();
	}

	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);
	}

}

//LocalDate rentDate;
// int timeOfLease; ara ta amaxia kathe fora poy fairnoyme neo car den dinoume
// hmeeromhnia
// edo na kano enum gia ton xrono kai na ton peraso mesa tis times ana mera
