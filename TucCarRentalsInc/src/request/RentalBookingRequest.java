package request;

import java.time.LocalDate;

public class RentalBookingRequest extends Request{

	private  String name;
	private String surname;
	private String licenseplate;
	private char category;
	private static final int counter = 000;
	private String id;
	
	public RentalBookingRequest(int referenceId,LocalDate timestamp,String status,String name,String surname,String licenseplate,char category) {
		super(referenceId,timestamp, status);
		this.name = name;
		this.surname = surname;
		this.licenseplate = licenseplate;
		this.category = category;
		this.id="RBRQ"+ counter;
	}
	
}
