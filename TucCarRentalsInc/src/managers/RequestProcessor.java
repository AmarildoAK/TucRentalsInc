package managers;
import java.awt.Taskbar.State;
import java.time.*;
import java.util.PriorityQueue;
import java.util.Queue;

import Vehicles.Vehicles;
import contracts.Contract;
import request.CustomerPayment;
import request.FinePayment;
import request.RentalBookingRequest;
import request.RentalCancelationRequest;
import request.RentalReturn;
import request.Request;
import storage.StorableList;
import storage.StorageManager;
import users.Admin;
import users.Customer;

public class RequestProcessor  {
private ContractManager contractManager;
private StatementManager statementManager;
private TransactionManager transactionManager;
private UserManager userManager;
private VehicleManager vehicleManager;
private int requestid;
LocalDate targetDate;
LocalDate currentDate;
private StorableList<Request<?>> dailyRequestList;
private StorableList<Request<?>> dailyFailedRequestList;
private StorableList<Request<?>> dailyProccessedRequestList;
//
//private StorableList<RentalBookingRequest> dailyRentalRequestList;αστο ακυρο δεν πρέπει να χρειάζεται καν να το κάνουμε αυτό γιατί αν κάνουμε κάτι τέτοιο θα πρέπει να εξυπηρετούμε όλα τα rentallbookingρε;θεστβ πρώτα κάτι που τελικα δεν είναι και πολύ σωστό

private Queue<Request<?>> requestQueue = new PriorityQueue<>();


private static RequestProcessor instance;

public static RequestProcessor getInstance() {
	if(instance == null) {
		instance = new RequestProcessor();
	}
return instance;
}


public RequestProcessor() {


	this.dailyRequestList = new StorableList<Request<?>>();

	
	
	try {
		
		StorageManager.getInstance().loadObject(this.dailyRequestList,"data/request/pending[YYYY-MM-DD].csv");
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}

public void processrequestloader(LocalDate currentDate) {
	
	for(Request requests:this.dailyRequestList) {
		requestQueue.add(requests);
	}
	

while(!requestQueue.isEmpty()) {
	
	
Request<?> requests = requestQueue.poll();


if(requests instanceof RentalBookingRequest) {
	
	
	RentalBookingRequest requestb = (RentalBookingRequest) requests;
	
	requestb.isValid();
	this.contractManager.CreateContract(requestb);
	
}
else if(requests instanceof RentalReturn) {
	RentalReturn requestReturn = (RentalReturn) requests;
	if(requestReturn.isValid()) {
		dailyProccessedRequestList.add(requestReturn);
	}
	else {dailyFailedRequestList.add(requestReturn);}
	
	//this.contractManager.CompletedContract(null);
	
}
else if(requests instanceof RentalCancelationRequest) {
	
	RentalCancelationRequest requestCancel = (RentalCancelationRequest) requests;
	
	if(requestCancel.isValid()) {
	this.contractManager.CancelContract(requestCancel);
	dailyProccessedRequestList.add(requestCancel);
	}else {dailyFailedRequestList.add(requestCancel);}
}
else if(requests instanceof FinePayment) {
	
	FinePayment finepay = (FinePayment) requests;
	
	if(finepay.isValid()) {
	Contract<?,?> FineContract = this.contractManager.findFineViolation(finepay.getVehicle(),finepay.getNoticeDay());
	
	if(FineContract != null) {
		
		Customer FineCustomer = FineContract.getCustomer();
		
		TransactionManager.getInstance().payFine(FineCustomer, finepay.getAmount());
		
	}else {
		System.out.println("No fine or contract found");
	}
	dailyProccessedRequestList.add(finepay);
	}else {dailyFailedRequestList.add(finepay);}
	
}
else if(requests instanceof CustomerPayment) {
	
	CustomerPayment customerPay = (CustomerPayment) requests;
	
	if(customerPay.isValid()) {
	Customer customer = this.userManager.findCustomer(customerPay.getCustomer().getVAT());
	
	if(customer != null) {
		
		TransactionManager.getInstance().PayBalance(customer,customerPay.getAmount());

	}else {
		System.out.println("No user payment found!!!");
	}
	dailyProccessedRequestList.add(customerPay);}else {dailyFailedRequestList.add(customerPay);}
	
	
	}
	
	
	
}

}


//public void SimulateTimePassing() {
//while(currentDate.isBefore(targetDate)) {
//	System.out.println("report for today :"+currentDate);
//
//	try {
//		StorageManager.getInstance().loadObject(this.dailyRequestList,"");
//	}catch(Exception e) {
//		
//	}
//}	
//}
//private StorableList <Request> getRentalRequest(StorableList<Request> dailyRequestList){
//	 
//}
}



	
	
	
	
	

