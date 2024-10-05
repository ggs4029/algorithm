// 백준 11816번
// 정수 입력이 8, 10, 16진수로 주어지면 그 값을 10진수로 바꿔서 출력하는 문제
// 방법---------------------
// 첫 줄에 정수 x를 입력 받음.
// if문을 사용해 8, 10, 16 중 어떤 진수 값인지 알아내고 10진수로 변환해 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 진수 판단
		int x = 0;
		if(input.length()>=3 && input.contains("0x")) {			// 16진수
			x = Integer.parseInt(input.substring(2), 16);
		}
		else if(input.length()>=2 && input.charAt(0)=='0') {	// 8진수
			x = Integer.parseInt(input, 8);
		}
		else {
			x = Integer.parseInt(input);
		}
		//출력
		System.out.print(x);
	}
}