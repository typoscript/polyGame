package main;

import java.util.Scanner;

public class Input {
	public static Scanner sc = new Scanner(System.in);
	
	public static String getInputString(String message) {
		System.out.print(message + ": ");
		return sc.next();
	}
}
