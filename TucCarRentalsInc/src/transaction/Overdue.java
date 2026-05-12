package transaction;

import java.time.LocalDate;

import storage.UnMarshalingException;

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
