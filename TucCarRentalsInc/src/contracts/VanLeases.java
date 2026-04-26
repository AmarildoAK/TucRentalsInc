package contracts;

import storage.UnMarshalingException;
import utils.CompanyVanCategory;
import utils.LeaseDuration;

public class VanLeases extends Contract {

	private CompanyVanCategory categoryVanCost;
	private LeaseDuration months;
	
	
	public VanLeases(String status,int contractID,CompanyVanCategory cost,LeaseDuration months) {
		super(status,contractID);
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
	
}
