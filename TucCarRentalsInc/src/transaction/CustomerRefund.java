package transaction;

import storage.UnMarshalingException;

public class CustomerRefund extends Credit{

	
	
	private Wallet w;
	private double refundRate = 0.8;
	private RentalCharge r;
	
	public CustomerRefund(int transactionID, int amountofReturn) {
		super(transactionID, amountofReturn);
		
	}
	
//	public void processcharge() {
//		w.setAmount(w.getAmount()-amountofReturn);
//	}

	
	public double CustomerRefundingCarPassenger () {
		return r.rentalChargeByDay() * refundRate;
		
	}
	
	
	public double CustomerRefundingCopmanyVan () {  // poly pithanon na xreiastoun orismata kai ta dyo
		return r.rentalChargeByMonth() * refundRate;
		
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
