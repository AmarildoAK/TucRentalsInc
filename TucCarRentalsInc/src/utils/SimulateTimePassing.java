package utils;

import java.time.LocalDate;

public class SimulateTimePassing {

	LocalDate startDate;
	LocalDate targetDate;
	LocalDate currentDate;
	public SimulateTimePassing(LocalDate startDate, LocalDate targetDate, LocalDate currentDate) {
		super();
		this.startDate = startDate;
		this.targetDate = targetDate;
		this.currentDate = currentDate;
	}
		
	public LocalDate getCurrentDate() {
		return currentDate;
	}
	public LocalDate setStartDate(LocalDate sDate) {
		return sDate;
	}
	public void addOneDay() {
		currentDate=currentDate.plusDays(1);
	}
	public void loopTillTargetDate(LocalDate target) {
		while(target.isAfter(currentDate)) {addOneDay();}// an kai h loopa ayth poly pithanon na ginei san method sto request processor
	}
	
	

	
}
