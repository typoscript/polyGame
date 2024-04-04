package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
	private static FileWriter fw;
	private static FileReader fr;
	private static BufferedReader br;
	
	public static String loadFile(String fileName) {
		String data = "";

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			while (br.ready())
				data += br.readLine();
			
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("파일 로드 실패");
		}
		
		return data;
	}
}
