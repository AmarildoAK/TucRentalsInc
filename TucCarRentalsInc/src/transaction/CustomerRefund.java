package transaction;

import java.time.LocalDateTime;

import Vehicles.CarPassanger;
import storage.UnMarshalingException;
import utils.CarPassengerVehicleType;

public class CustomerRefund extends Credit{

	
	
	private Wallet w;
	private static double refundRate = 0.8;
	private static RentalCharge r;
	public static final double percent=0.8;
	
	public CustomerRefund(String referenceId,LocalDateTime timestamp, double amountofReturn) {
		super(referenceId,timestamp, amountofReturn);
		
	}
	
//	public void processcharge() {
//		w.setAmount(w.getAmount()-amountofReturn);
//	}

	
	public static double CustomerRefundingCarPassenger (int days,CarPassengerVehicleType car) {
		
		double total = 0.0;
		
		total=days*car.getPrice();
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
