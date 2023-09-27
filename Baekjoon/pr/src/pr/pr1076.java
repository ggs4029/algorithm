// 백준 1076번
// 3개의 색을 이용해 저항을 구하는 문제
// 방법--------------------------
// 첫째 둘째 셋째 줄에 색을 입력 받는다.
// 입력 받은 색에 따라 저항값을 switch문으로 구분해 string 문자열로 추가
// 문자열이 완성되면 parseLong을 이용해 long 타입으로 바꿔준 뒤 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1076 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 색 입력
		String r = "";
		for (int x = 0; x < 3; x++) {
			String input = br.readLine();
			// switch문으로 계산 ( String r에 자릿수를 추가하는 식으로)
			switch (input) {
			case "black":
				if (x != 2) {
					r = r + "0";
				}
				break;
			case "brown":
				if (x != 2) {
					r = r + "1";
				} else {
					r = r + "0";
				}
				break;
			case "red":
				if (x != 2) {
					r = r + "2";
				} else {
					r = r + "00";
				}
				break;
			case "orange":
				if (x != 2) {
					r = r + "3";
				} else {
					r = r + "000";
				}
				break;
			case "yellow":
				if (x != 2) {
					r = r + "4";
				} else {
					r = r + "0000";
				}
				break;
			case "green":
				if (x != 2) {
					r = r + "5";
				} else {
					r = r + "00000";
				}
				break;
			case "blue":
				if (x != 2) {
					r = r + "6";
				} else {
					r = r + "000000";
				}
				break;
			case "violet":
				if (x != 2) {
					r = r + "7";
				} else {
					r = r + "0000000";
				}
				break;
			case "grey":
				if (x != 2) {
					r = r + "8";
				} else {
					r = r + "00000000";
				}
				break;
			case "white":
				if (x != 2) {
					r = r + "9";
				} else {
					r = r + "000000000";
				}
				break;
			}
		}
		// 출력
		long output = Long.parseLong(r);
		System.out.print(output);
	}
}