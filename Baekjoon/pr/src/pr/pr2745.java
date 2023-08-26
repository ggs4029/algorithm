// 백준 2745번
// B진법 수 N이 주어지면 10진법으로 출력하는 문제
// 방법--------------------------
// N과 B를 한 줄에 입력 받고
// 진법 계산을 통해 10진법으로 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2745 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int b = Integer.parseInt(input[1]); // B진법
		// A~Z의 아스키코드 65~90, 0~9의 아스키코드 48~57
		int sum = 0;
		for (int x = 0; x < input[0].length(); x++) {
			if ((input[0].charAt(x) - 48) <= 9) { // 숫자면
				sum += (input[0].charAt(x) - 48) * Math.pow(b, input[0].length()-1-x);
			} else { // 숫자가 아닌 대문자 알파벳이면
				sum += (input[0].charAt(x) - 55) * Math.pow(b, input[0].length()-1-x);
			}
		}
		System.out.print(sum);
	}
}