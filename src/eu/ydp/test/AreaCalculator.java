package eu.ydp.test;

import java.util.Scanner;

public class AreaCalculator {

	public static void main(String[] args) {
		
		boolean ok = true;
		Scanner s = new Scanner(System.in);
		
		while (ok) {
			System.out.print("calculator > ");
			String commandString = s.nextLine();
			
			System.out.println("Command: " + commandString);
		}
		s.close();		
		
	}
	
}
