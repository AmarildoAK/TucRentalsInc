package request;

import java.time.LocalDate;

import storage.UnMarshalingException;

public class RentalCancelationRequest extends Request {
	
	

	private int  RentalbookingreferencetID;
	private static final int counter = 000;
	private String Id;

	public RentalCancelationRequest(int referenceId,LocalDate timestamp,String status,int rentalbookingreferencetID) {
		super(referenceId,timestamp, status);
		this.RentalbookingreferencetID = rentalbookingreferencetID;
		this.Id="RCRQ"+counter;
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

// mallon tha prepei edo na kanoume mia method find requets by id h opoia tha scanarei ola ta rentalBooking request kai tha epistrefei ayto to request kai tis plhrofories tou 
// alla logika ayto tha ginei ston manager