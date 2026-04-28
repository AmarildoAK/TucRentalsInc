package Vehicles;

import storage.Storable;
import storage.UnMarshalingException;

//kai edo mporoyme na kanoume enum gia ta tria tier list poy yparxoyn
//theloume sigoura ena checker gia kathe pinakida oti einia swsto format(ara regex)kai monadikh
public abstract class Vehicles implements Storable,Comparable<Vehicles> {
	private String  licensePlate;
	private String category;
	private boolean available;
	private String transmission;
	private String make;
	private String model;
	private String year;	
	
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
		this.licensePlate = licensePlate;
		this.category = catgerory;
	this.available = true;
	this.transmission = transmission;
	this.make=make;
	this.model=model;
	this.year=year;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	private void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	private String getCatgerory() {
		return category;
	}
	private void setCatgerory(String catgerory) {
		this.category = catgerory;
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
		
		
		sb.append("licensePlate").append(this.licensePlate).append(",");
		sb.append("category").append(this.category).append(",");
		sb.append("available").append(this.available).append(",");
		sb.append("transmission").append(this.transmission).append(",");
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

			if (keyValue[0].trim().equals("firstName")) {
				this.licensePlate = keyValue[1];
			} else if (keyValue[0].trim().equals("lastName")) {
				this.category = keyValue[1];
			} else if (keyValue[0].trim().equals("email")) {
				this.available = Boolean.parseBoolean(keyValue[1]);

			}

		}

	}

}

