package utils;

public enum CarPassengerVehicleType {
 
	ECONOMY(50),
	STANDARD(75),
	PREMIUM(100);
	
	private int  pricePerDay;

	private CarPassengerVehicleType(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public double getPrice() {
		return pricePerDay;
	}

	
	
}
