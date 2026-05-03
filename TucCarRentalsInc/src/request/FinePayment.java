package request;

import java.time.LocalDate;

public class FinePayment extends Request{

	private static final int counter = 000;
	private String id;
    private String licenseplate;
	private LocalDate violationDay;

	
	public FinePayment(int referenceId, LocalDate timestamp,String status,String licenseplate,LocalDate violationDay) {
		super(referenceId, timestamp, status);
		this.id="FRQ"+id;
	this.licenseplate = licenseplate;
	this.violationDay = violationDay;
	
	}


	@Override
	public int compareTo(Request o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
	
	
	
	
}
