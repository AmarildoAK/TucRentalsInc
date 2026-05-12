

package request;

import java.time.LocalDate;

import Vehicles.Vehicles;
import managers.UserManager;
import storage.UnMarshalingException;
import users.Company;
import users.Customer;
import users.Individual;
public class CustomerPayment extends Request<CustomerPayment>{
private static int requestidCounter =1;
private int requestId;
private double amount;
private static final int counter = 000;
private String referenceId;
private Customer customer;

public Customer getCustomer() {
	return customer;
}




public void setCustomer(Customer customer) {
	this.customer = customer;
}




public CustomerPayment(String referenceId, LocalDate timestamp,double amount,String type) {
	super(referenceId, timestamp,type);
	
	this.amount = amount;
	this.referenceId="PRQ"+counter;
}




private static int getRequestidCounter() {
	return requestidCounter;
}




private static void setRequestidCounter(int requestidCounter) {
	CustomerPayment.requestidCounter = requestidCounter;
}




private int getRequestId() {
	return requestId;
}




private void setRequestId(int requestId) {
	this.requestId = requestId;
}




public double getAmount() {
	return amount;
}




private void setAmount(double amount) {
	this.amount = amount;
}




public String getReferenceId() {
	return referenceId;
}




private void setReferenceId(String referenceId) {
	this.referenceId = referenceId;
}




private static int getCounter() {
	return counter;
}




@Override
public int compareTo(Request o) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public String marshal() {
	StringBuffer sb = new StringBuffer(super.marshal());
	
	sb.append("referenceId").append(this.referenceId).append(",");
	 sb.append("vat").append(this.customer.getVAT()).append(",");
	sb.append("amount").append(this.amount).append(",");
	 
	return sb.toString();
}

@Override
public void unmarshal(String data) throws UnMarshalingException {
	
	super.unmarshal(data);

    if(data == null) {
        throw new UnMarshalingException("Empty Data");
        }


    String[] parts = data.split(",");
    for (String part : parts) {
        String[] keyValue = part.split(":");

        if(keyValue[0].trim().equals("referenceId")) {
        	this.referenceId = keyValue[1];
        }else if(keyValue[0].trim().equals("vat")) {
        	this.customer = (Customer)UserManager.getInstance().findCustomer(keyValue[1]);
        }
        else if(keyValue[0].trim().equals("amount")) {
        	this.amount = Double.parseDouble(keyValue[1]);
        }
        	
        
    }
	
}

@Override
public int getPriority() {
	// TODO Auto-generated method stub
	return 0;
}


}
