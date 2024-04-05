package utils;

import java.util.List;

public class Print {
	public static void printListWithListNumber(List<?> list) {
		System.out.println("=== 리스트 ===");
		for (int i = 0; i < list.size(); i++)
			System.out.printf("%d. %s\n", i + 1, list.get(i));
		System.out.println("============");
	}
}
