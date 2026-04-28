package Vehicles;

import storage.Storable;
import storage.UnMarshalingException;
import utils.CarPassengerVehicleType;

//kai edo mporoyme na kanoume enum gia ta tria tier list poy yparxoyn
//theloume sigoura ena checker gia kathe pinakida oti einia swsto format(ara regex)kai monadikh
public abstract class Vehicles implements Storable,Comparable<Vehicles> {
	private String  licenseplate;
	private boolean available;
	private String transmission;
	private String make;
	private String model;
	private String year;	

	protected CarPassengerVehicleType category;

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	private void setYear(String year) {
		this.year = year;
	}
	public Vehicles(String licensePlate, String catgerory,String transmission,String make,String model,String year) {
		this.licenseplate = licensePlate;
		this.category = catgerory;

	this.available = true;
	this.transmission = transmission;
	this.make=make;
	this.model=model;
	this.year=year;
	}

	private String getLicenseplate() {
		return licenseplate;
	}


	private void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}



	private String getCategory() {
		return category;
	}



	private void setCategory(String category) {
		this.category = category;
	}

    public String getLicensePlate() {
		return licenseplate;
	}
	private void setLicensePlate(String licensePlate) {
		this.licenseplate = licensePlate;
	}
	

	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String getTransmission() {
		return transmission;
	}
	private void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	
	
	
	
	
	@Override
	public int compareTo(Vehicles other) {
		return this.getLicensePlate().compareTo(other.getLicensePlate());
	}
	
	
	
	@Override
	public String marshal() {
		StringBuffer sb = new StringBuffer("type: ").append(this.getClass().getName()).append(";");
		
		
		sb.append("licenseplate:").append(this.licenseplate).append(",");
		sb.append("available:").append(this.available).append(",");
		sb.append("transmission:").append(this.transmission).append(",");
		return sb.toString();
	}

	@Override
	public void unmarshal(String data) throws UnMarshalingException {

		
		if(data == null) {
			throw new UnMarshalingException("Empty Data");
			}
		
		
		String[] parts = data.split(",");
		for (String part : parts) {
			String[] keyValue = part.split(":");

			if (keyValue[0].trim().equals("licenseplate")) {
				this.licenseplate = keyValue[1];
			}else if (keyValue[0].trim().equals("available")) {
				this.available = Boolean.parseBoolean(keyValue[1]);}
			else if(keyValue[0].trim().equals("transmission")) {
				this.transmission = keyValue[1];
			}
			else if(keyValue[0].trim().equals("category")) {
				this.category = keyValue[1];
			}

		}

	}

}

