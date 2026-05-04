package transaction;

import storage.UnMarshalingException;
import users.Customer;

public class CustomerPayment extends Credit {
 
	
	private RentalCharge r;
	private Wallet w;
	public CustomerPayment(int transactionID, int amountofReturn) {
		super(transactionID, amountofReturn);
		// TODO Auto-generated constructor stub
	}
	
	
//	public void processcharge() {
//		w.setAmount(w.getAmount()-amountofReturn);
//	}

	
	public void RepayDebtCarPassanger(Customer customer,double payment) {
		
		Wallet w = customer.getWallet();
		
		
		double total = w.getAmount() - payment;
		 w.setAmount(total);
		
	}
	
	
	public void RepayDebtCompanyVan(Customer customer,double payment) {
		
		Wallet w = customer.getWallet();
		
		double total=w.getAmount() - payment;
		w.setAmount(total);
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
