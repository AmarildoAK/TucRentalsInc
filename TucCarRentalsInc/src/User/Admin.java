package User;
import java.time.*;

import storage.UnMarshalingException;

public class Admin extends user {

LocalDate targetDate;


public Admin(String email, String password, String firstName, String lastName,String username) {
    super(email,password,firstName,lastName,username);




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
	
	return sb.toString();
}

@Override
public void unmarshal(String data) throws UnMarshalingException {
super.unmarshal(data);
}




}