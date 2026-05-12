package transaction;

import java.time.LocalDateTime;

import storage.UnMarshalingException;

public class CustomerRefund extends Credit{

	
	
	private Wallet w;
	private static double refundRate = 0.8;
	private static RentalCharge r;
	
	public CustomerRefund(String referenceId,LocalDateTime timestamp, double amountofReturn) {
		super(referenceId,timestamp, amountofReturn);
		
	}
	
//	public void processcharge() {
//		w.setAmount(w.getAmount()-amountofReturn);
//	}

	
	public static double CustomerRefundingCarPassenger () {
		
		double total = 0.0;
		
		total = r.rentalChargeByDay() * refundRate;
		return total;
		
	}
	
	
	
	

	
public String marshal() {
		
		StringBuffer sb = new StringBuffer(super.marshal());
		
		return sb.toString();
	}
	
	
	public void unmarshal(String data) throws UnMarshalingException {
		super.unmarshal(data);
		}

	@Override
	public int compareTo(Transaction o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
}
