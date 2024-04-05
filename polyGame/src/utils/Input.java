package main;

import java.util.Scanner;

public class Input {
	public static Scanner sc = new Scanner(System.in);
	
	public static String getInputString(String message) {
		System.out.print(message + ": ");
		return sc.next();
	}
	
	public static int getInputNumber(String message) {
		while (true) {
			try {
				String input = getInputString(message);
				return Integer.parseInt(input);
			} catch (Exception e) { }
		}
	}
}
