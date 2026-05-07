package utils;

import java.time.LocalDate;

public class SimulateTimePassing {

	private LocalDate startDate;
	
	private static LocalDate currentDate;
	public SimulateTimePassing(LocalDate startDate, LocalDate targetDate, LocalDate currentDate) {
		super();
		this.startDate = startDate;
		
		SimulateTimePassing.currentDate = currentDate;//why this fixes it?  because its static?
	}
		
	public static LocalDate getCurrentDate() {
		return currentDate;
	}
	private LocalDate getStartDate() {
		return startDate;
	}

	private static void setCurrentDate(LocalDate currentDate) {
		SimulateTimePassing.currentDate = currentDate;
	}

	public void setStartDate(LocalDate sDate) {
		this.startDate=sDate;
	}
	public void addOneDay() {
		currentDate=currentDate.plusDays(1);
	}
	public void loopTillTargetDate(LocalDate target) {
		while(target.isAfter(currentDate)) {addOneDay();}// an kai h loopa ayth poly pithanon na ginei san method sto request processor
	}
	
	

	
}
