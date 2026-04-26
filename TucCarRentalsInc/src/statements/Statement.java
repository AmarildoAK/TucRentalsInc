package statements;

import java.time.LocalDate;

import storage.UnMarshalingException;

public class Statement {

	private LocalDate timestamp;
	private String statementType;
	private double amount;
	private String creator;
	private String description;
	private int noticeID;
	
	public Statement(LocalDate timestamp,String statementType,double amount,String creator,String description,int noticeID) {
		
	this.amount = amount;
	this.creator = creator;
	this.description = description;
	this.statementType = statementType;
	this.timestamp = timestamp;
	this.noticeID = noticeID;
	
	}

	private LocalDate getTimestamp() {
		return timestamp;
	}

	private void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	private String getStatementType() {
		return statementType;
	}

	private void setStatementType(String statementType) {
		this.statementType = statementType;
	}

	private double getAmount() {
		return amount;
	}

	private void setAmount(double amount) {
		this.amount = amount;
	}

	private String getCreator() {
		return creator;
	}

	private void setCreator(String creator) {
		this.creator = creator;
	}

	private String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	private int getNoticeID() {
		return noticeID;
	}

	private void setNoticeID(int noticeID) {
		this.noticeID = noticeID;
	}
	
	public String marshal() {
		StringBuffer sb = new StringBuffer("type: ").append(this.getClass().getName()).append(";");
		
		
		sb.append("timestamp").append(this.timestamp).append(",");
		sb.append("amount").append(this.amount).append(",");
		sb.append("creator").append(this.creator).append(",");
		sb.append("noticeID").append(this.noticeID).append(",");
		sb.append("description").append(this.description).append(",");
		sb.append("statementType").append(this.statementType).append(",");
		
		

		return sb.toString();
	}
	
	
public void unmarshal(String data) throws UnMarshalingException {
		
	if(data == null) {
		throw new UnMarshalingException("Empty Data");
		}

		String[] parts = data.split(",");
		for(String part: parts) {
			String[] keyValue = part.split(":");
			
			if(keyValue[0].trim().equals("creator")) {
				this.creator = keyValue[1];
			}else if(keyValue[0].trim().equals("statementType")) {
				this.statementType = keyValue[1];
			}else if(keyValue[0].trim().equals("description")) {
				this.description = keyValue[1];
			}else if(keyValue[0].trim().equals("timestamp")) {
				this.timestamp =LocalDate.parse(keyValue[1]);
			}
			else if(keyValue[0].trim().equals("amount")) {
				this.amount = Double.parseDouble(keyValue[1]);
			}
			else if(keyValue[0].trim().equals("noticeID")) {
				this.noticeID = Integer.parseInt(keyValue[1]);
			}
		}
	
	
	
	
}

	
	
	
}
