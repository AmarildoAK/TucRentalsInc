package transaction;

import Vehicles.Vehicles;
import storage.Storable;
import storage.StorableList;
import storage.UnMarshalingException;

public class Wallet implements Storable, Comparable<Wallet> {
	private double amount;
	private StorableList<Transaction> statementHistory;
	private int WalletID;
	private static int WalletIdCounter = 1;

	public Wallet(double amount) { // StorableList<Transaction> statementHistory mporei na xreiastei en telei !!!

		this.amount = amount;
		this.statementHistory = statementHistory;
		this.WalletID = WalletIdCounter++;

	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getWalletID() {
		return WalletID;
	}

	private void setWalletID(int walletID) {
		WalletID = walletID;
	}

@Override
public int compareTo(Wallet other) {

	return this.getWalletID() - other.getWalletID();
}

	@Override
	public String marshal() {
		StringBuffer sb = new StringBuffer("type: ").append(this.getClass().getName()).append(";");

		sb.append("amount").append(this.amount).append(",");
		sb.append("WalletID").append(this.WalletID).append(",");

		return sb.toString();

	
	}

	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		if(data == null) {
			throw new UnMarshalingException("Empty Data");
			}
		
		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
			if(keyValue[0].trim().equals("Status")) {
				this.WalletID = Integer.parseInt(keyValue[1]);
			}else if(keyValue[0].trim().equals("ContractID")) {
				this.amount = Double.parseDouble(keyValue[1]);
			
		}
	}

	}

}
