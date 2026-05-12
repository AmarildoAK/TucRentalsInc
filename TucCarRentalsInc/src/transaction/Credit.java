package transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Credit extends Transaction {

	

	public Credit(String referenceId,LocalDateTime timestamp, double amount) {
		super(referenceId, amount);
	
	}



	
	
	
	
	
}
