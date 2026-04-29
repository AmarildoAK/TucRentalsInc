package utils;

import java.util.Scanner;

public class MyScanner {

	private Scanner scan;
	
	public MyScanner() {
		this.scan = new Scanner(System.in);
	}

	public String  readString(String prompt) {
		
		System.out.println(prompt+": ");
		String input = scan.next();
		return input;
		
		
	}

	public int readInt(String prompt) {
		
		System.out.println(prompt+": ");
		int input = scan.nextInt();
		return input;
	}
	public int read(String prompt) {
		
		System.out.println(prompt+": ");
		int input = scan.nextInt();
		return input;
	}


	public static int nextInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int nextInt1() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
