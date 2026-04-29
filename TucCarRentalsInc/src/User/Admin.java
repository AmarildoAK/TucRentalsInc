package User;
import java.time.*;

import storage.UnMarshalingException;

public class Admin extends user {

LocalDate targetDate;
private String username;
private String type = "Admin";


public Admin(String password,String name,String username) {
    super(password,name);




}

public LocalDate getTargetDate() {
    return targetDate;
}
private void setTargetDate(LocalDate targetDate) {
    this.targetDate = targetDate;
}

@Override
public String marshal() {

	StringBuffer sb = new StringBuffer(super.marshal());
	
	sb.append("username").append(this.username).append(",");
	sb.append("type:").append(this.type).append(",");
	
	return sb.toString();
}

@Override
public void unmarshal(String data) throws UnMarshalingException {
super.unmarshal(data);
if(data == null) {
	throw new UnMarshalingException("Empty Data");
	}

	String[] parts = data.split(",");
	for(String part: parts) {
		String[] keyValue = part.split(":");
		
		if(keyValue[0].trim().equals("username")) {
			this.username= keyValue[1];
		}
		
	}
	}



}



