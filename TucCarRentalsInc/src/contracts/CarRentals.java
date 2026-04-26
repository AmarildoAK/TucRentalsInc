package contracts;

import java.time.LocalDate;

import User.Customer;
import storage.UnMarshalingException;
import utils.CarPassengerVehicleType;

public class CarRentals extends Contract {

	private CarPassengerVehicleType categoryCost;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate currentDay;
	private int days;
	private Customer customer;
	private String licenseplate;
	
	public CarRentals(String status,int contractID,CarPassengerVehicleType categoryCost,int days,LocalDate startDate,LocalDate endDate,String licenseplate,Customer customer) {
		super(status,contractID);
this.categoryCost = categoryCost;
this.startDate = startDate;
this.endDate = endDate;
	this.days = days;
	this.licenseplate = licenseplate;
	this.customer = customer;
	this.currentDay = LocalDate.now();
	}
	
	
	
	
	
	
	private String getLicenseplate() {
		return licenseplate;
	}






	private void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}






	private CarPassengerVehicleType getCost() {
		return categoryCost;
	}





	private void setCost(CarPassengerVehicleType cost) {
		this.categoryCost = cost;
	}







	private CarPassengerVehicleType getCategoryCost() {
		return categoryCost;
	}





	private void setCategoryCost(CarPassengerVehicleType categoryCost) {
		this.categoryCost = categoryCost;
	}





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





	private LocalDate getCurrentDay() {
		return currentDay;
	}






	private void setCurrentDay(LocalDate currentDay) {
		this.currentDay = currentDay;
	}






	private int getDays() {
		return days;
	}






	private void setDays(int days) {
		this.days = days;
	}






	private Customer getCustomer() {
		return customer;
	}






	private void setCustomer(Customer customer) {
		this.customer = customer;
	}






	public double CalculateCost() {
		return this.findDays(days) * this.categoryCost.getPrice();
	}
	

	private int  findDays(int days) {// ayth mallon tha xreaistei na ginei overload gia ta vanleashes
		LocalDate indexdate;
		indexdate=endDate;
	while(indexdate.isBefore(currentDay)) {// na valo allo ena periorismo typoy den exei plhrothei η να καλώ την μέθοδο αυτή αφού δεν πληρωθεί
		days++;
		indexdate=indexdate.plusDays(1);
	}
	return days;
	}
	
	
	
	
	
	
	@Override
public String marshal() {
		
		StringBuffer sb = new StringBuffer(super.marshal());
		
		sb.append("days").append(this.days).append(",");
		sb.append("categoryCost").append(this.categoryCost).append(",");
		sb.append("startDate").append(this.startDate).append(",");
		sb.append("endDate").append(this.endDate).append(",");
		sb.append("customer").append(this.customer.getVAT()).append(",");
		sb.append("licenseplate").append(this.licenseplate).append(",");

		
		return sb.toString();
	}
	
	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);
		
		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
			if(keyValue[0].trim().equals("days")) {
				this.days = Integer.parseInt(keyValue[1]);
			}else if(keyValue[0].trim().equals("CategoryCost")) {
				this.categoryCost = CarPassengerVehicleType.valueOf(keyValue[1].trim()); // edw ti paizei ti tha kanoume gia auto !!!!
			}else if(keyValue[0].trim().equals("startDate")) {
					this.startDate = LocalDate.parse(keyValue[1].trim());
				}
			else if(keyValue[0].trim().equals("endDate")) {
			this.endDate = LocalDate.parse(keyValue[1].trim());
			}
	
			else if(keyValue[0].trim().equals("customer")) {
				
	}
	
	
	
}
	}
	
}
