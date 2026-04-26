package managers;

import Vehicles.Vehicles;
import storage.StorableList;
import storage.StorageManager;

public class VehicleManager {
// edo tha einai to vehicleRepo to opoio tha einai array list typou Vehicle
// kai theloume kai generics gia na diaxwrizoyme thn leasing apo thn hmerisia 

private StorableList<Vehicles> vehicleList;
private Vehicles vehicle;




public VehicleManager() {
	this.vehicleList = new StorableList<>();
	
	try {
		StorageManager.getInstance().loadObject(this.vehicleList,"fleet.csv");
		System.out.println("This vehicle have been added succesfully");

	
	}catch(Exception e) {
		System.out.println("Error"+e.getMessage());

	}
}



private StorableList<Vehicles> getVehicleList() {
	return vehicleList;
}



private void setVehicleList(StorableList<Vehicles> vehicleList) {
	this.vehicleList = vehicleList;
}



private Vehicles getVehicle() {
	return vehicle;
}



private void setVehicle(Vehicles vehicle) {
	this.vehicle = vehicle;
}



public Vehicles findVehicle(String licensePlate) {
	
	for(int i=0; i<vehicleList.size();i++) {
		if(vehicleList.get(i).getLicensePlate().equals(licensePlate)) {
			return vehicleList.get(i);
		}
	}
	
	return null;
	
}


public boolean addVehicle(Vehicles v) {

	if (findVehicle(v.getLicensePlate()) != null) {

		return false;
	} else {

		vehicleList.add(v);
		try {
			StorageManager.getInstance().storeObject(vehicleList,"fleet.csv");
			System.out.println("Vehicle succesfully added");
		}catch(Exception e){
			System.out.println("Error trying to add vehicle");
		}
	
		return true;	
	}
}

public boolean Availability(String licensePlate) {
	
Vehicles v = findVehicle(licensePlate);

if(v!=null) {
	return v.isAvailable();
}else {
	
	System.out.println("The vehicle is already rented");
	return false;
}

}



}
