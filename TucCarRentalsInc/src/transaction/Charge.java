package transaction;

public abstract class Charge extends Transaction {


	public Charge(String referenceId,double amount) {
		super(referenceId, amount);
	
	
	}

	
}
