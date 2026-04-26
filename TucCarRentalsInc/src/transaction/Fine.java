package transaction;

import java.time.LocalDate;

import Vehicles.Vehicles;
import contracts.Contract;
import managers.ContractManager;
import storage.UnMarshalingException;

public class Fine extends Charge  {

	private int noticeID;
	private LocalDate currentDate; 
	private String reasonForFine;
	private ContractManager c;
	private Vehicles v;
	
	public Fine (int transactionID,float amount) {
		super(transactionID, amount);
	}

	
	
//	
//	public double FineCharge() {
//		for(Contract contract:c.contractList) {
//			if(contract.getRentedCar().getLicensePlate().equals()) {
//				
//				
//				
//			}
//		}
//	}
	
	
	
	
	
	
	
	
	@Override
	public int compareTo(Transaction o) {
		
		return 0;
	}
	
public String marshal() {
		
		StringBuffer sb = new StringBuffer(super.marshal());
		
		sb.append("noticeID").append(this.noticeID).append(",");
		
		return sb.toString();
	}
	
	
	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);
		
		if(data == null) {
			throw new UnMarshalingException("Empty Data");
			}
		
		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
		
		if(keyValue[0].trim().equals("Status")) {
			this.noticeID = Integer.parseInt(keyValue[1]);
		}
	
	}
	
	
}
}