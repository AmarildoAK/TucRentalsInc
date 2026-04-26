package request;

import java.time.LocalDate;

public class RentalReturn extends Request{
	private int  RentalbookingreferencetID;
	private static final int counter = 000;
	private String id;
	public RentalReturn(int referenceId, LocalDate timestamp,String status,int RentalbookingreferencetID) {
		super(referenceId, timestamp, status);
		this.RentalbookingreferencetID=RentalbookingreferencetID;
		this.id="RRRQ"+counter;
	}
   
	
	
}
