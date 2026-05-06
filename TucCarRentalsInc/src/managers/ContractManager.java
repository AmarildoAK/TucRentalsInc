package managers;

import java.time.LocalDate;

import Vehicles.Vehicles;
import contracts.CarRentals;
import contracts.Contract;
import contracts.VanLeases;
import storage.StorableList;
import storage.StorageManager;
import transaction.Wallet;
import users.Customer;
import users.Individual;

public class ContractManager {

	public StorableList<Contract> contractList;
	private Contract c;
	private Wallet wallet;
	private LocalDate today;
	
	public static ContractManager instance;
	
	public static ContractManager getInstance() {
		if(instance == null) {
			instance = new ContractManager();
		}
	
	return instance;
	}
	
	
	
	
	public ContractManager() {
		this.contractList = new StorableList<>();
		
		try {
			StorageManager.getInstance().loadObject(this.contractList,"Data/contracts/contracts.csv");
			System.out.println("The contracts have been added succesfully");
		}catch(Exception e) {
			System.out.println("Error"+e.getMessage());

		}
	}
	
	
	
	
	
	
private StorableList<Contract> getContractList() {
		return contractList;
	}

	private void setContractList(StorableList<Contract> contractList) {
		this.contractList = contractList;
	}


	private Contract getC() {
		return c;
	}

	private void setC(Contract c) {
		this.c = c;
	}

	private Wallet getWallet() {
		return wallet;
	}

	private void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}


public Contract findContract(String contractId) {
	for(int i=0;i<contractList.size();i++) {
		if(contractList.get(i).getContractID().equals(contractId)) {
			return contractList.get(i);
		}
	}
	return null;
}


public Contract findContractViolation(String licenseplate,LocalDate violationDate) {
	for(int i=0;i<contractList.size();i++) {
		if(contractList.get(i).getRentedCar().getLicenseplate().equals(licenseplate) && contractList.get(i).getStartDate().isBefore(violationDate)&& contractList.get(i).getEndDate().isAfter(violationDate)) {
			return contractList.get(i);
		}
	}
	return null;
}



public boolean CreateContract(Contract newContract) {
	if(findContract(newContract.getContractID())!=null) {
		return false;
	}
	contractList.add(newContract);
	try {
		StorageManager.getInstance().storeObject(contractList,"Data/contracts/contracts.csv");
		System.out.println("The new Contract has been added!!!");
	}catch(Exception e){
		System.out.println("The contract has met an Error"+e.getMessage());
	}

return true;
}

public void CancelContract(String contractID) {
	
	c = findContract(contractID);
	
	if(c!= null && c.getStatus().equals("ACTIVE")) {
		c.setStatus("Cancelled");
		
		Vehicles rentedCar = c.getRentedCar();
		rentedCar.setAvailable(true);
	}
		System.out.println("Contract cancelled succesfully");
	
		
		
		try {
			StorageManager.getInstance().storeObject(contractList,"Data/contracts/contracts.csv");
			System.out.println("The new Contract has been cancelled!!!");
		}catch(Exception e){
			System.out.println("The contract has met an Error"+e.getMessage());
		}
	
		
	}



public void CompletedContract(String contractID) {
	c = findContract(contractID);
	if(c!=null && c.getStatus().equalsIgnoreCase("ACTIVE")) {
		c.setStatus("Completed");
		
		Vehicles rentedCar = c.getRentedCar();
		
		
		rentedCar.setAvailable(true);
		System.out.println("The contract has been succesfully completed");
	
		try {
			StorageManager.getInstance().storeObject(contractList,"Data/contracts/contracts.csv");
			System.out.println("The new Contract has been added!!!");
		}catch(Exception e){
			System.out.println("The contract has met an Error"+e.getMessage());
		}
	
	}else {
		System.out.println("error while trying for completion");
	}
}



 public boolean checkMotion(Contract c, LocalDate today) {
	 
	 if (c.getStartDate().isBefore(today)&&c.getEndDate().isAfter(today)&&c.getStatus().equals("ACTIVE")) {
		return true;
	}
	return false;
	 
 

 }
public boolean checkFuture(Contract c, LocalDate today) {
	 
	 if (c.getStartDate().isAfter(today)&&c.getStatus().equals("ACTIVE")) {
		return true;
	}
	return false;
	 
 

 }
 public String getInMotionContracts(Individual i) {
	 
	 for(Contract con : contractList) {
		 if(con instanceof CarRentals) {
			 CarRentals cr = (CarRentals) con;
			 if (cr.getTempVAT().equals(i.getVAT())&& checkMotion(con, today)) {
				 return cr.toString(); // ή την toString ή την marshal
				
			}
			 
		 }
		 else if (con instanceof VanLeases) {
			VanLeases vl =(VanLeases) con;
			if (vl.getTempVAT().equals(i.getVAT())&& checkMotion(con, today)) {
				 return vl.toString(); // ή την toString ή την marshal
		}
	
			
		}
		 return "No match found";
	 }
	 return null;
	 	}
 
 
 
 public String getFutureContracts(Individual i) {
	 
	 for(Contract con : contractList) {
		 if(con instanceof CarRentals) {
			 CarRentals cr = (CarRentals) con;
			 if (cr.getTempVAT().equals(i.getVAT())&& checkFuture(con, today)) {
				 return cr.toString(); // ή την toString ή την marshal
				
			}
			 
		 }
		 else if (con instanceof VanLeases) {
			VanLeases vl =(VanLeases) con;
			if (vl.getTempVAT().equals(i.getVAT())&& checkFuture(con, today)) {
				 return vl.toString(); // ή την toString ή την marshal
		}
	
			
		}
		 return "No match found";
	 }
	 return null;
 }
 



}
 

//public void Overview(Customer customer) {
//	int activeContracts = 0;
//	int pendingcontracts = 0;
//	
//	
//	System.out.println("Your current balance is:"+customer.getWallet().getAmount());
//	
//	
//	
//	
//	
//	
//}


 



