package managers;

import java.time.LocalDate;

import Vehicles.CarPassanger;
import Vehicles.CompanyVan;
import Vehicles.Vehicles;
import contracts.CarRentals;
import contracts.Contract;
import contracts.VanLeases;
import storage.StorableList;
import storage.StorageManager;
import transaction.CustomerRefund;
import transaction.Overdue;
//import transaction.Overdue
import transaction.Wallet;
import users.Company;
import users.Customer;
import users.Individual;
import utils.CarPassengerVehicleType;
import utils.CompanyVanCategory;
import request.RentalBookingRequest;
import request.RentalCancelationRequest;
import request.RentalReturn;
import request.Request;

public class ContractManager {

	public StorableList<Contract<?, ?>> contractList;
	private Contract<?, ?> c;
	private Wallet wallet;
	private LocalDate today;
	private Request request;

	public static ContractManager instance;

	public static ContractManager getInstance() {
		if (instance == null) {
			instance = new ContractManager();
		}

		return instance;
	}


	public ContractManager() {
		this.contractList = new StorableList<Contract<?, ?>>();

		try {
			StorageManager.getInstance().loadObject(this.contractList, "Data/contracts.csv");
			System.out.println("The contracts have been added succesfully");
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());

		}
	}
	

	private StorableList<Contract<?, ?>> getContractList() {
		return contractList;
	}

	private void setContractList(StorableList<Contract<?, ?>> contractList) {
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

	public Contract<?, ?> findContract(String referenceId) {

		for (Contract c : contractList) {
			if (c.getReferenceId().equals(referenceId)) {
				return c;
			}
		}

		return null;
	}

// edw ti einai protimotero na paroume olo to oxhma h mono string th pinakida ??? 

	public Contract<?, ?> findFineViolation(Vehicles licenseplate, LocalDate violationDate) {
		for (int i = 0; i < contractList.size(); i++) {
			if (contractList.get(i).getCar().getLicenseplate().equals(licenseplate)
					&& contractList.get(i).getStartDate().isBefore(violationDate)
					&& contractList.get(i).getEndDate().isAfter(violationDate)) {
				return contractList.get(i);
			}
		}
		return null;
	}

	public void CancelContract(RentalCancelationRequest request) {

		c = findContract(request.getReferenceId());

		if (c != null && c.getStatus().equals("ACTIVE")) {
			c.setStatus("Cancelled");

			Vehicles rentedCar = c.getCar();
			rentedCar.setAvailable(true);
		}
		System.out.println("Contract cancelled succesfully");

		try {
			StorageManager.getInstance().storeObject(contractList, "Data/contracts/contracts.csv");
			System.out.println("The new Contract has been cancelled!!!");
		} catch (Exception e) {
			System.out.println("The contract has met an Error" + e.getMessage());
		}

	}

	public void CompletedContract(RentalReturn request, Contract<?, ?> contract) {

		LocalDate actualReturn = request.getTimestamp();
		LocalDate expectedRentalReturn = contract.getEndDate();

		if (contract instanceof CarRentals) {
			CarPassanger categoryCar = (CarPassanger) contract.getCar();

			if (contract.getReferenceId().equals(request.getReferenceId()) && contract.getStatus().equals("ACTIVE")) { // den
																														// eimai
																														// katholou
																														// sigouros
																														// gia
																														// auto
				contract.setStatus("COMPLETED");
				contract.getCar().setAvailable(true);

				if (actualReturn.isAfter(expectedRentalReturn)) {
					int days = Overdue.findextraDays(contract.getEndDate(), request.getTimestamp());
					double amountOverdue = Overdue.calculateAmountForCarPassanger(categoryCar.getVehicleCategory(),
							days);
					Overdue charge = new Overdue(request.getReferenceId(), request.getTimestamp(), amountOverdue);
					TransactionManager.getInstance().PayBalance(contract.getCustomer(), amountOverdue);
					
				}
				else if(actualReturn.isBefore(expectedRentalReturn)) {
					int days = Overdue.findextraDays(request.getTimestamp(),contract.getEndDate() );
					double amountReturn = CustomerRefund.CustomerRefundingCarPassenger(days,categoryCar.getVehicleCategory());
					Overdue charge = new Overdue(request.getReferenceId(), request.getTimestamp(), amountReturn);
					TransactionManager.getInstance().PayBalance(contract.getCustomer(), amountReturn);// edo na allajei??
					
				}
				else {
					// int days =
					// Overdue.findextraDays(contract.getEndDate(),request.getTimestamp());
//					double amountRefund = CustomerRefund.CustomerRefundingCarPassenger(0, null);
//		CustomerRefund refund = new CustomerRefund(request.getReferenceId(),request.getTimestamp(), amountRefund);
				}

			}
		}

		if (contract instanceof VanLeases) {
			CompanyVan categVan = (CompanyVan) contract.getCar();
			if (contract.getReferenceId().equals(request.getReferenceId()) && contract.getStatus().equals("ACTIVE")) { // den
																														// eimai
																														// katholou
																														// sigouros
																														// gia
																														// auto
				contract.setStatus("COMPLETED");
				contract.getCar().setAvailable(true);
				if (actualReturn.isAfter(expectedRentalReturn)) {
					int days = Overdue.findextraDays(contract.getEndDate(), request.getTimestamp());
					double amountOverdue = Overdue.calculateAmountForCompanyVan(categVan.getVancategory(), days);
					Overdue charge = new Overdue(request.getReferenceId(), request.getTimestamp(), amountOverdue);
					TransactionManager.getInstance().PayBalance(contract.getCustomer(), amountOverdue);
					
				}
				

			}

		}

	}


	public boolean checkMotion(Contract<?, ?> c, LocalDate today) {

		if (c.getStartDate().isBefore(today) && c.getEndDate().isAfter(today) && c.getStatus().equals("ACTIVE")) {
			return true;
		}
		return false;

	}

	public boolean checkFuture(Contract<?, ?> c, LocalDate today) {

		if (c.getStartDate().isAfter(today) && c.getStatus().equals("ACTIVE")) {
			return true;
		}
		return false;

	}

	public String getInMotionContracts(Customer c) {

		for (Contract con : contractList) {
			if (con instanceof CarRentals) {
				CarRentals cr = (CarRentals) con;
				if (cr.getCustomer().getVAT().equals(c.getVAT()) && checkMotion(con, today)) {
					return cr.toString(); // ή την toString ή την marshal

				}

			} else if (con instanceof VanLeases) {
				VanLeases vl = (VanLeases) con;
				if (vl.getCustomer().getVAT().equals(c.getVAT()) && checkMotion(con, today)) {
					return vl.toString(); // ή την toString ή την marshal
				}

			}
			return "No match found";
		}
		return null;
	}

	public String getFutureContracts(Customer c) {

		for (Contract<?, ?> con : contractList) {
			if (con instanceof CarRentals) {
				CarRentals cr = (CarRentals) con;
				if (cr.getCustomer().getVAT().equals(c.getVAT()) && checkFuture(con, today)) {
					return cr.toString(); // ή την toString ή την marshal

				}

			} else if (con instanceof VanLeases) {
				VanLeases vl = (VanLeases) con;
				if (vl.getCustomer().getVAT().equals(c.getVAT()) && checkFuture(con, today)) {
					return vl.toString(); // ή την toString ή την marshal
				}

			}
			return "No match found";
		}
		return null;
	}

	public String getActiveCompanyContracts(Company comp) {
		String printable = "";
		for (Contract c : contractList) {
			if (c instanceof VanLeases && c.getStatus().equals("ACTIVE")) {
				printable += c.toString();
			}
		}
		return printable;
	}

	public Contract<?, ?> CreateContract(RentalBookingRequest request) {
		double estimatedCost = 0;

		Customer customer = UserManager.getInstance().findCustomer(request.getCustomer().getVAT());

		if (customer == null) {
			throw new IllegalArgumentException("ERROR");
		}

		if (customer instanceof Individual) {
			Individual i = (Individual) customer;
			Vehicles vehicle = VehicleManager.getInstance().findVehicleByCategory(request.getVehicle().getCategory());
			CarPassanger car = (CarPassanger) vehicle;
			if (vehicle != null) {
				CarRentals carRental = new CarRentals(request.getStartDate(), request.getEndDate(),

						request.getReferenceId(), i, car, request.getCateg());// εδω λογικά θα θέλει Individual i = new
																				// (Individual) customer

				estimatedCost = carRental.CalculateCost();
				car.setAvailable(false);
				this.contractList.add(carRental);

				try {
					StorageManager.getInstance().storeObject(contractList, "Data/contracts/contracts.csv");
					System.out.println("The new Contract has been added!!!");
				} catch (Exception e) {
					System.out.println("The contract has met an Error" + e.getMessage());
				}

				return carRental;

			}

		} else if (customer instanceof Company) {
			Company c = (Company) customer;
			Vehicles vehicle = VehicleManager.getInstance().findVehicleByCategory(request.getVehicle().getCategory());
			CompanyVan van = (CompanyVan) vehicle;

			if (vehicle != null) {
				VanLeases vanlease = new VanLeases(request.getStartDate(), request.getEndDate(),
						request.getReferenceId(), c, van, request.getCategoryVan());
				estimatedCost = vanlease.CalculateCost();
				van.setAvailable(false);
				this.contractList.add(vanlease);

				try {
					StorageManager.getInstance().storeObject(contractList, "Data/contracts.csv");
					System.out.println("The new Contract has been added!!!");
				} catch (Exception e) {
					System.out.println("The contract has met an Error" + e.getMessage());
				}

				return vanlease;
			}

		}
		return null;

	}



public void loadContract() {
	try {
		StorageManager.getInstance().loadObject(this.contractList, "Data/contracts/contracts.csv");
		System.out.println("The contracts have been added succesfully");
	} catch (Exception e) {
		System.out.println("Error" + e.getMessage());

	}
}

public void saveContract() {
	try {
		StorageManager.getInstance().storeObject(contractList, "Data/contracts/contracts.csv");
		System.out.println("The new Contract has been added!!!");
	} catch (Exception e) {
		System.out.println("The contract has met an Error" + e.getMessage());
	}
}




}



