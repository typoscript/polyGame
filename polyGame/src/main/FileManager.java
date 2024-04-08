package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import hero.Hero;

public class FileManager {
	private static String DATA_DIR = "src/data";
	private static FileWriter fw;
	private static FileReader fr;
	private static BufferedReader br;
	
	public static String loadFile(String fileName) {
		String data = "";

		try {
			fr = new FileReader(DATA_DIR + fileName);
			br = new BufferedReader(fr);
			
			while (br.ready())
				data += br.readLine() + "\n";
			
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("파일 로드 실패");
		}
		
		return data;
	}
}
