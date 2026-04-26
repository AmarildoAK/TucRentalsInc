package utils;

public enum CompanyVanCategory {

	ECONOMY(500),
	STANDARD(800),
	PREMIUM(1200);
	
	private int monthlyLease;
	
	CompanyVanCategory(int monthlyLease){
		this.monthlyLease = monthlyLease;
	}

	public int getMonthlyLease() {
		return monthlyLease;
	}

	
	
	
	
}
