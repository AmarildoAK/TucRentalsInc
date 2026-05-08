package request;

import java.time.LocalDate;

import storage.UnMarshalingException;

public class FinePayment extends Request{

	private static final int counter = 000;
	private String id;
    private String licenseplate;
	private LocalDate violationDay;

	
	public FinePayment(String referenceId, LocalDate timestamp,String status,String licenseplate,LocalDate violationDay) {
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
