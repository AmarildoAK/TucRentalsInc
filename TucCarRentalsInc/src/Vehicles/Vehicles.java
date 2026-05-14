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
	private int year;	
    private String category;
    private String type;

	
	public Vehicles(String licensePlate, String category,String transmission,String make,String model,int  year) {
	
	if(CheckType(type)&&CheckLicenseplate(licenseplate)&&CheckCategory(category)&&CheckTransmission(transmission)&&CheckMake(make)&&CheckModel(model) ) {
		
		this.licenseplate = licensePlate;
	this.category = category;
	this.available = true;
	this.transmission = transmission;
	this.make=make;
	this.model=model;
	this.year=year;
	}
	}
	public Vehicles() {}

	
	
	
	private String getType() {
		return type;
	}


	private boolean CheckType(String type) {
		return this.type!=null && !type.trim().isEmpty();
	}


	protected void setType(String type) {
		this.type = type;
	}




	public String getLicenseplate() {
		return licenseplate;
	}

	private boolean CheckLicenseplate(String licenseplate) {
		return licenseplate!=null && !licenseplate.trim().isEmpty();
	}

	private void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}



	public String getCategory() {
		return category;
	}

private boolean CheckCategory(String category) {
	return category!=null && !category.trim().isEmpty();
}

	private void setCategory(String  category) {
		this.category = category;
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
	
	private boolean CheckTransmission(String transmission) {
		return transmission!=null && !transmission.trim().isEmpty();
	}
	
	private void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	public String getMake() {
		return make;
	}
	
	private boolean CheckMake(String make) {
		return make!=null && !make.trim().isEmpty();
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	
	private boolean CheckModel(String model) {
		return model!=null &&!model.trim().isEmpty();
	}
	
	
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	private void setYear(int year) {
		this.year = year;
	}
	
	
	
	
	@Override
	public int compareTo(Vehicles other) {
		return this.getLicenseplate().compareTo(other.getLicenseplate());
	}
	
	
	
	@Override
	public String marshal() {
		StringBuffer sb = new StringBuffer("type: ").append(this.getClass().getName()).append(";");
		
		
		sb.append("type:").append(this.type).append(",");
		sb.append("plate:").append(this.licenseplate).append(",");
		sb.append("make:").append(this.make).append(",");
		sb.append("model:").append(this.model).append(",");
		sb.append("transmission:").append(this.transmission).append(",");
		sb.append("year").append(this.year).append(",");
		
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

			if (keyValue[0].trim().equals("type")) {
				this.type = keyValue[1];
			}
			else if(keyValue[0].trim().equals("plate")) {
				this.licenseplate = keyValue[1];
			}
			else if(keyValue[0].trim().equals("make")) {
				this.make = keyValue[1];
			}
			else if(keyValue[0].trim().equals("model")) {
				this.model = keyValue[1];
			}
			else if(keyValue[0].trim().equals("transmission")) {
				this.transmission = keyValue[1];
			}
			else if(keyValue[0].trim().equals("year")) {
				this.year = Integer.parseInt(keyValue[1]);
			}

		}

	}

}

