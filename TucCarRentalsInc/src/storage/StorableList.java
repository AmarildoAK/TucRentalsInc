 package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StorableList<T extends Storable & Comparable<T>> extends ArrayList<T> implements Storable{

	
	private static final Map<String,String> typeMap = createMap();

    private static Map<String,String> createMap(){

        Map<String, String> map = new HashMap<>();
        map.put("Admin", "users.Admin");
        map.put("Company", "users.Company");
        map.put("Individual", "users.Individual");

        map.put("PassengerCar","Vehicles.CarPassanger");
        map.put("CommercialVan","Vehicles.CompanyVan");

        map.put("RentalBookingRequest", "request.RentalBookingRequest");
        map.put("CustomerPayment", "request.CustomerPayment");
        map.put("FinePayment", "request.FinePayment");
        map.put("RentalCancelation", "request.RentalCancelation");
        map.put("RentalReturn", "request.RentalReturn");
        map.put("CarRentals", "contract.CarRentals");
        map.put("VanLeases", "contract.VanLeases");

        map.put("Charge", "transactions.Charge");
        map.put("Fine", "transactions.Fine");
        map.put("CustomerPayment", "transactions.CustomerPayment");
        map.put("Overdue", "transactions.Overdue");
        map.put("ContractRefund","transactions.ContractRefund");

        map.put("Statement", "statement.Statement");

        return map;
    }
	
	
	
	
	
	
	
	@Override
	public String marshal() {
		StringBuffer sb = new StringBuffer();
		for(T item:this) {
			sb.append(item.marshal()).append("\n");
		}
		return sb.toString();
	}

	@Override
	public void unmarshal(String data) throws UnMarshalingException {
		
		try {
			String[] lines = data.split("\n");
			for(String line: lines) {
				if(line.trim().isEmpty()) {
					continue;
				}
				
				String className = "";
				String[] parts = line.split(",");
				try {
					if(parts[0].contains(":")) {
						className = parts[0].split(":")[1].trim();
					}else {
						className = parts[0].trim();
					}
				
					String ClassPath = typeMap.get(className);
					
					if(ClassPath == null) {
						ClassPath = className;
					}
					
					//className = parts[0].split(":")[1].trim();
					Class<?> typeClass = Class.forName(ClassPath);
					if(typeClass != null) {
						@SuppressWarnings("Unchecked")
						T item = (T) typeClass.getDeclaredConstructor().newInstance();
						item.unmarshal(line);
						add(item);
					}
				}catch(UnMarshalingException e) {
					System.out.println("Error unmarshalling item: "+className+ e.getMessage());
				}catch(Exception e) {
					System.out.println("Error creating instance item: "+ e.getMessage());
				}
			}
		}catch(Exception e) {
		throw new UnMarshalingException(e.getMessage());
		}
		
	}

	
	


}
