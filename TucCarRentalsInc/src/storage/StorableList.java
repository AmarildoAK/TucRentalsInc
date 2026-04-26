 package storage;

import java.util.ArrayList;

public class StorableList<T extends Storable & Comparable<T>> extends ArrayList<T> implements Storable{

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
				String className = "";
				try {
					String[] parts = line.split(",");
					className = parts[0].split(":")[1].trim();
					Class<?> typeClass = Class.forName(className);
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
