package managers;
import java.awt.Taskbar.State;
import java.time.*;
import java.util.PriorityQueue;
import java.util.Queue;

import Vehicles.Vehicles;
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
private StorableList<Request<?,?>> dailyRequestList;
//
//private StorableList<RentalBookingRequest> dailyRentalRequestList;αστο ακυρο δεν πρέπει να χρειάζεται καν να το κάνουμε αυτό γιατί αν κάνουμε κάτι τέτοιο θα πρέπει να εξυπηρετούμε όλα τα rentallbookingρε;θεστβ πρώτα κάτι που τελικα δεν είναι και πολύ σωστό

private Queue<Request<?,?>> requestQueue = new PriorityQueue<>();





public RequestProcessor(ContractManager contractManager, StatementManager statementManager,
		TransactionManager transactionManager, UserManager userManager, VehicleManager vehicleManager, int requestid,
		LocalDate targetDate, LocalDate currentDate) {
	super();
	this.contractManager = contractManager;
	this.statementManager = statementManager;
	this.transactionManager = transactionManager;
	this.userManager = userManager;
	this.vehicleManager = vehicleManager;
	this.requestid = requestid;
	this.targetDate = targetDate;
	this.currentDate = currentDate;

	this.dailyRequestList = new StorableList<>();
	this.dailyRequestList = new StorableList<>();
	
	try {
		
		StorageManager.getInstance().loadObject(this.dailyRequestList,"Data/request/pending");
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}

public void processrequestloader() {
	
	for(Request requests:this.dailyRequestList) {
		requestQueue.add(requests);
	}
	
	



while(!requestQueue.isEmpty()) {
	
	
Request requests = requestQueue.poll();


if(requests instanceof RentalBookingRequest) {
	
	RentalBookingRequest requestb = (RentalBookingRequest) requests;
	
	//this.contractManager.CreateContract(requestb);
	
}
else if(requests instanceof RentalReturn) {
	
}
else if(requests instanceof RentalCancelationRequest) {
	
}
else if(requests instanceof FinePayment) {
	
}
else if(requests instanceof CustomerPayment) {
	
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



	
	
	
	
	

