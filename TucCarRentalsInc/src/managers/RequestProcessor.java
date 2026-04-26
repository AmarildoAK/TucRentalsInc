package managers;
import java.awt.Taskbar.State;
import java.time.*;


//import com.sun.source.tree.WhileLoopTree;

import User.Admin;
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



	
	
	
	
	

