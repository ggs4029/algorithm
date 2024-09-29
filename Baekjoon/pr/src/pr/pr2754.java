// 백준 2754번
// 성적이 주어지면 몇점인지 출력하기
// 방법---------------------
// 첫 줄에 성적이 입력되면 성적에 맞는 평점을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2754 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 평점 계산
		double output = 0;
		switch (input) {
		case "A+" : output = 4.3;
					break;
		case "A0" : output = 4.0;
					break;
		case "A-" : output = 3.7;
					break;
		case "B+" : output = 3.3;
					break;
		case "B0" : output = 3.0;
					break;
		case "B-" : output = 2.7;
					break;
		case "C+" : output = 2.3;
					break;
		case "C0" : output = 2.0;
					break;
		case "C-" : output = 1.7;
					break;
		case "D+" : output = 1.3;
					break;
		case "D0" : output = 1.0;
					break;
		case "D-" : output = 0.7;
					break;
		}
		//출력
		System.out.print(output);
	}
}