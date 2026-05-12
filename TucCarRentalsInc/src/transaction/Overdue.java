package transaction;

import java.time.LocalDate;

import storage.UnMarshalingException;
import utils.CarPassengerVehicleType;
import utils.CompanyVanCategory;

public class Overdue extends Charge {
// edo mhpow
	private int extraDayCharge;
	private int overduedays;
	LocalDate expirationDate;
	LocalDate currentDay;// θα την πάρουμε μέσα από την simulate time passing
	private int contractID;
 
	
	
	public Overdue(String referenceId, LocalDate timestamp,double amount) {
		super(referenceId, amount);

	}

	
	
	public static int  findextraDays(LocalDate endDate,LocalDate returnDate) {// ayth mallon tha xreaistei na ginei overload gia ta vanleashes
		
		 int overduedays =0;
		 LocalDate indexdate;
			indexdate= endDate;    //expirationDate;
		while(indexdate.isBefore(returnDate)) {// na valo allo ena periorismo typoy den exei plhrothei η να καλώ την μέθοδο αυτή αφού δεν πληρωθεί
			overduedays++;
			indexdate=indexdate.plusDays(1);
		}
		return overduedays;
		}
		
		public static double calculateAmountForCarPassanger(CarPassengerVehicleType car,int overdueDay) {// idio kai ayth
			
			double getpriceCat = car.getPrice();
			
			double overdueCharge = getpriceCat *1.2;
		
			double totalAmount = overdueCharge * overdueDay;
				
			return totalAmount;	
		}

		
		public static double calculateAmountForCompanyVan(CompanyVanCategory van,int overdueDay) {
		
		double priceVan = van.getMonthlyLease();
		
		return priceVan;
		
		}

	
	
	@Override
	public String marshal() {
	
StringBuffer sb = new StringBuffer(super.marshal());
		
sb.append("contractID").append(this.contractID).append(",");

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

			if (keyValue[0].trim().equals("contractId")) {
				this.contractID = Integer.parseInt(keyValue[1]);
			}
		
		
	}
}
	@Override
	public int compareTo(Transaction o) {
		
		return 0;
	}

}
