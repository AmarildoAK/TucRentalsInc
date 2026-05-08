package request;

import java.time.LocalDate;

import storage.UnMarshalingException;
import users.Company;
import users.Customer;
import users.Individual;
public class CustomerPayment extends Request{
private static int requestidCounter =1;
private int requestId;
Customer c;
Individual i;
Company comp;// gia na paro to vat
double amount;
private static final int counter = 000;
private String paymentId;

public CustomerPayment(String referenceId, LocalDate timestamp, String status,Customer c,double amount) {
	super(referenceId, timestamp, status);
	this.c = c;
	this.amount = amount;
	this.paymentId="PRQ"+counter;
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









