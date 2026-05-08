package request;

import java.time.LocalDate;

import storage.Storable;
import storage.UnMarshalingException;

public class RentalBookingRequest extends Request { // local date den tha eprepe na eixe ????

	private  String name;
	private String surname;
	private String licenseplate; // mhpws na exei typo Vehicles???
	private static final int counter = 000;
	private String id;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	public RentalBookingRequest(String referenceId,LocalDate timestamp,String status,String name,String surname,String licenseplate,char category) {
		super(referenceId,timestamp, status);
		this.name = name;
		this.surname = surname;
		this.licenseplate = licenseplate;
		this.category = category;
		this.id="RBRQ"+ counter;
	}

	
	@Override
	public int compareTo(Request o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String marshal() {
		
		return null;
	}

	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		// TODO Auto-generated method stub
		
	}
	
}
