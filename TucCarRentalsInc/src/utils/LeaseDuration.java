package utils;

public enum LeaseDuration {

	SMALL(6),
	MEDIUM(12),
	BIG(24);
	
	private int MonthNum ;
	
	 LeaseDuration(int MontNum) {
		this.MonthNum = MonthNum;
	}

	 public int getMonthNum() {
		return MonthNum;
	}

	 
	
	
}
