package board.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
	
	// 특정 기능을 쓰는것이므로 static을 붙여도 괜찮고, 편하다.
	public static String getCurrentDate() {

		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		String formatedNow = now.format(formatter);

		return formatedNow;
	}

}