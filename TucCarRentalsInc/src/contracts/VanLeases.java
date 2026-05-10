package contracts;

import java.time.LocalDate;

import Vehicles.CarPassanger;
import Vehicles.CompanyVan;
import Vehicles.Vehicles;
import request.RentalBookingRequest;
import storage.UnMarshalingException;
import users.Company;
import users.Customer;
import users.Individual;
import utils.CarPassengerVehicleType;
import utils.CompanyVanCategory;
import utils.LeaseDuration;

public class VanLeases extends Contract<CompanyVan,Company> {

	private CompanyVanCategory categoryVanCost;
	private LeaseDuration months;


	
	public VanLeases(LocalDate startDate,LocalDate endDate,String referenceId,Company company,CompanyVan compaVan,CompanyVanCategory categoryCost) {
		super(company,compaVan,referenceId,startDate,endDate);
		this.categoryVanCost = categoryCost;
		;
	}

	
	private CompanyVanCategory getCost() {
		return categoryVanCost;
	}


	private LeaseDuration getMonths() {
		return months;
	}


	public double CalculateCost() {
		return categoryVanCost.getMonthlyLease() * months.getMonthNum();
	}
	
	@Override
public String marshal() {
		
		StringBuffer sb = new StringBuffer(super.marshal());
		
		sb.append("CategoryVanCost").append(this.categoryVanCost).append(",");
		sb.append("Months").append(this.months).append(",");
		

		
		
		return sb.toString();
	}
	
	
	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);
		
		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
			if(keyValue[0].trim().equals("Days")) {
				this.categoryVanCost = CompanyVanCategory.valueOf(keyValue[1]);
			}else if(keyValue[0].trim().equals("CategoryCost")) {
				this.months = LeaseDuration.valueOf(keyValue[1]); 
				}
			
	
	
	
}
	
	
	
	
	
	}


	


	@Override
	public int compareTo(Contract o) {
		// TODO Auto-generated method stub
		return 0;
	}                                         

	
	private int calculateMonthsVan(RentalBookingRequest request) {

		int calculatedMonths = 0;
		LocalDate indexMonth = request.getStartDate();
		while (indexMonth.isBefore(request.getEndDate())) {

			calculatedMonths++;

			indexMonth = indexMonth.plusMonths(1);
		}

		if (calculatedMonths == 6) {
			this.months = LeaseDuration.SMALL;
		} else if (calculatedMonths == 12) {
			this.months = LeaseDuration.MEDIUM;
		} else if (calculatedMonths == 24) {
			this.months = LeaseDuration.BIG;
		}

		else {
			System.out.println("Wrong month error while trying to calcualte");
			this.months = LeaseDuration.SMALL;
		}

		return calculatedMonths;

	}
}
	
	
	
	

