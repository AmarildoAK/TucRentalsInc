package request;

import java.time.LocalDate;

import storage.UnMarshalingException;

public class RentalReturn extends Request{
	private int  RentalbookingreferencetID;
	private static final int counter = 000;
	private String id;
	public RentalReturn(String referenceId, LocalDate timestamp,String status,int RentalbookingreferencetID) {
		super(referenceId, timestamp, status);
		this.RentalbookingreferencetID=RentalbookingreferencetID;
		this.id="RRRQ"+counter;
	}
	@Override
	public int compareTo(Request o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String marshal() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		// TODO Auto-generated method stub
		
	}
   
	
	
}
