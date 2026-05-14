package managers;

import Vehicles.CarPassanger;
import Vehicles.CompanyVan;
import Vehicles.Vehicles;
import contracts.VanLeases;
import storage.StorableList;
import storage.StorageManager;

public class VehicleManager {
// edo tha einai to vehicleRepo to opoio tha einai array list typou Vehicle
// kai theloume kai generics gia na diaxwrizoyme thn leasing apo thn hmerisia 

private StorableList<Vehicles> vehicleList;
private Vehicles vehicle;
private static VehicleManager instance;

public static VehicleManager getInstance() {
	if(instance == null) {
		instance = new VehicleManager();
	}
return instance;
}



private  VehicleManager() {
	this.vehicleList = new StorableList<>();
	
	try {
		StorageManager.getInstance().loadObject(this.vehicleList,"Data/vehicles/fleet.csv");
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
	
	if(vehicle.getLicenseplate() == null) {
		return null;
	}
	
	
	for(Vehicles v:vehicleList) {
		if(v.getLicenseplate().equals(licensePlate)) {
			return v;
		}
	}
	
	return null;
	
}

public Vehicles findVehicleByCategory(String category) {
	if(vehicle.getCategory() == null) {
		return null;
	}

	
for(Vehicles v:vehicleList) {
	if(v.getCategory().toString().equals(category)) {
		return v;
	}

}
return null;
}

public boolean addVehicle(Vehicles v) {

	if (findVehicle(v.getLicenseplate()) != null) {

		return false;
	} else {

		vehicleList.add(v);
		try {
			StorageManager.getInstance().storeObject(vehicleList,"Data/vehicles/fleet.csv");
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


public Vehicles availabilityByCategoryForCar(String Categ) {
	
for(Vehicles v : vehicleList) {
	if (v instanceof CarPassanger) {
		CarPassanger car =  (CarPassanger) v;
		if (car.getType().equals(Categ)) {
			return v;
		}
		
	}
		
	}
return null;

}
public Vehicles availabilityByCategoryForVan(String Categ) {
	
for(Vehicles v : vehicleList) {
	if (v instanceof CompanyVan) {
		CompanyVan van =  (CompanyVan) v;
		if (van.getType().equals(Categ)) {
			return v;
		}
	
		
	}
	}
return null;

}
	

public void printVehicles() {
	for (int i = 0; i < vehicleList.size(); i++) {
		
		if (vehicleList.get(i) instanceof CarPassanger) {
			CarPassanger c = (CarPassanger) vehicleList.get(i);
			System.out.println("type: "+c.getType()+" plate: "+c.getLicenseplate()+" make: "+c.getMake()+" model: "+c.getModel()+" transminssion: "+c.getTransmission()+" year: "+c.getYear());	 
		}
		else if (vehicleList.get(i) instanceof CompanyVan) {
			CompanyVan v = (CompanyVan) vehicleList.get(i);
				System.out.println("type: "+v.getType()+" plate: "+v.getLicenseplate()+" make: "+v.getMake()+" model: "+v.getModel()+" transminssion: "+v.getTransmission()+" year: "+v.getYear());	 
			}
		}
	}


public void loadVehicle() {
this.vehicleList = new StorableList<>();
	
	try {
		StorageManager.getInstance().loadObject(this.vehicleList,"Data/vehicles/fleet.csv");
		System.out.println("This vehicle have been added succesfully");

	
	}catch(Exception e) {
		System.out.println("Error"+e.getMessage());

	}
}

public void saveVehicle() {
	try {
		StorageManager.getInstance().storeObject(vehicleList,"Data/vehicles/fleet.csv");
		System.out.println("Vehicle succesfully added");
	}catch(Exception e){
		System.out.println("Error trying to save vehicle");
	}
}


}




