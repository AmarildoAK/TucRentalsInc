package managers;
import java.awt.Taskbar.State;
import java.time.*;
import java.util.PriorityQueue;
import java.util.Queue;

//import com.sun.source.tree.WhileLoopTree;

import User.Admin;
import request.Request;
import storage.StorableList;
import storage.StorageManager;

public class RequestProcessor  {
private ContractManager contractManager;
private StatementManager statementManager;
private TransactionManager transactionManager;
private UserManager userManager;
private VehicleManager vehicleManager;
private int requestid;
LocalDate targetDate;
LocalDate currentDate;
private StorableList dailyRequestList;


private Queue<Request> requestQueue = new PriorityQueue<>();





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

	try {
		
		StorageManager.getInstance().loadObject(this.dailyRequestList,"Data/request/pending");
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}






public void addRequest(Request request) {
	requestQueue.add(request);
}



public void SimulateTimePassing() {
while(currentDate.isBefore(targetDate)) {
	System.out.println("report for today :"+currentDate);

	try {
		StorageManager.getInstance().loadObject(this.dailyRequestList,"");
	}catch(Exception e) {
		
	}
	
	
	
	
	
	//	contractManager;
//	statementManager;
//	transactionManager;
//	userManager;
//	vehicleManager;

	
	
	
	
	currentDate=currentDate.plusDays(1);
}	
}


}



	
	
	
	
	

