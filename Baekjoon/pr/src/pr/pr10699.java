// 백준 10699번
// 오늘 날짜 출력
// 방법---------------------
// 오늘 날짜를 출력한다.

import java.io.IOException;
import java.time.LocalDate;

public class pr10699 {
	public static void main(String[] args) throws IOException {
		//출력
		LocalDate output = LocalDate.now();
		System.out.println(output);
	}
}