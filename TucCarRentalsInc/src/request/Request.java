package request;

import java.time.LocalDate;

import storage.Storable;

public abstract class Request implements Storable,Comparable<Request>{

	private static int referenceIDcounter =1;
	private int referenceId;
	protected String status;
	private LocalDate requestDay;
	
	
	private static int getReferenceIDcounter() {
		return referenceIDcounter;
	}



	private static void setReferenceIDcounter(int referenceIDcounter) {
		Request.referenceIDcounter = referenceIDcounter;
	}



	private String getStatus() {
		return status;
	}



	private void setStatus(String status) {
		this.status = status;
	}



	private int getReferenceId() {
		return referenceId;
	}

	private LocalDate timestamp;
	

	public Request(int referenceId,LocalDate timestamp,String status) {
		this.referenceId = referenceIDcounter++;
		this.timestamp=timestamp;
		this.status=status;

	}
	


	private void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	private LocalDate getTimestamp() {
		return timestamp;
	}

	private LocalDate setTimestamp(LocalDate timestamp) {
		return this.timestamp = timestamp;
	}



@Override
public int compareTo(Request other) {
	return this.requestDay.compareTo(other.requestDay);
	
}



}