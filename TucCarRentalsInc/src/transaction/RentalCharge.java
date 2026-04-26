package transaction;
import java.time.LocalDate;

import User.Customer;
import contracts.CarRentals;
import contracts.Contract;
import contracts.VanLeases;
import managers.UserManager;
import storage.UnMarshalingException;
import utils.CarPassengerVehicleType;
import utils.CompanyVanCategory;
public class RentalCharge extends Charge {

	private CarRentals c;
	private VanLeases v;
	private LocalDate startofRent;
	private LocalDate finishOfRent;
	private int rentingDays;
	private int cost;
	private Transaction t;
	private Wallet wallet;
	private Customer customer;
	//private int CustomerCount = 0;
	private UserManager u;
	private int contractID;
	private CarPassengerVehicleType categoryCost;
	private CompanyVanCategory companyVanCost;
	
	
	
	public RentalCharge(int transactionID, float amount) {
		super(transactionID, amount);
		// TODO Auto-generated constructor stub
	}

	
	private int  findrentingDays() {// ayth mallon tha xreaistei na ginei overload gia ta vanleashes
		LocalDate indexdate;
		indexdate=startofRent;
	while(indexdate.isBefore(finishOfRent)) {// na valo allo ena periorismo typoy den exei plhrothei η να καλώ την μέθοδο αυτή αφού δεν πληρωθεί
		rentingDays++;
		indexdate=indexdate.plusDays(1);
	}
	return rentingDays;
	}
	

	public double rentalChargeByDay() {
		//elenxoi se auta 
		return rentingDays * categoryCost.getPrice();
				
	}
	
    public double rentalChargeByMonth() {
		
    	return rentingDays * companyVanCost.getMonthlyLease();
    	
    	
	}
	
	

		
		
		
	
	
	@Override
	public String marshal() {
StringBuffer sb = new StringBuffer(super.marshal());
		
sb.append("licensePlate").append(this.contractID).append(",");

		return sb.toString();
	}

	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		
		super.unmarshal(data);

		if(data == null) {
			throw new UnMarshalingException("Empty Data");
			}
		
		
		String[] parts = data.split(",");
		for (String part : parts) {
			String[] keyValue = part.split(":");

			if (keyValue[0].trim().equals("contractID")) {
				this.contractID = Integer.parseInt(keyValue[1]);
			}
		
		
		
	}
	}
	@Override
	public int compareTo(Transaction o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
