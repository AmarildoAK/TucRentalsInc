package contracts;

import User.Customer;
import Vehicles.Vehicles;
import storage.UnMarshalingException;
import utils.CompanyVanCategory;
import utils.LeaseDuration;

public class VanLeases extends Contract {

	private CompanyVanCategory categoryVanCost;
	private LeaseDuration months;
	private Customer customer ;
	private String tempVAT;
	
	public VanLeases(String status,int contractID,CompanyVanCategory cost,LeaseDuration months,Vehicles rentedCar) {
		super(status,contractID,rentedCar);
		this.categoryVanCost = cost;
		this.months = months;
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
		sb.append("customerVAT").append(this.customer.getVAT()).append(",");

		
		
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
			else if(keyValue[0].trim().equals("customerVAT")) {
				this.setTempVAT(keyValue[1]);
			}
	
	
	
}
	
	
	
	
	
	}


	public String getTempVAT() {
		return tempVAT;
	}


	public void setTempVAT(String tempVAT) {
		this.tempVAT = tempVAT;
	}                                         
	
}
