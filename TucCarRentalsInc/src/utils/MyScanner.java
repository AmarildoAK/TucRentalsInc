package utils;

import java.time.LocalDate;
import java.util.Scanner;

public class MyScanner {

	private static Scanner scan = new Scanner(System.in);
	
	public MyScanner() {}

	public static String readString() {
		
		return scan.next();
		
		
	}

	public static int readInt() {
		int value = scan.nextInt();
		scan.nextLine();
		return value;
	}
	

public static double readDouble() {
	double value = scan.nextDouble();
	scan.nextLine();
	return value;
	
}
//public static LocalDate readLocalDate() {
////	LocalDate value = scan.next();
//	scan.nextLine();
//	return value;
//	
//}

}
	
	
	

