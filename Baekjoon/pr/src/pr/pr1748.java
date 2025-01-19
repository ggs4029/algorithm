// 백준 1748번
// 1부터 N까지의 수를 이어서 쓴 새로운 수는의 자릿수를 구하는 문제.
// 방법---------------------
// 첫 줄에 n을 입력 받음.
// while문으로 자릿수 늘려가며 더해가기.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pr1748 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 자릿수 구하기
		int digits = 1;								// 현재 자릿수
		int num = 1;								// 현재 자릿수의 시작 숫자
		long output = 0;
		while(num <= n) {
			int tmp = Math.min(num*10-1, n);		// 이번 자릿수의 끝 값
			output += (tmp - num + 1) * digits;		// 자릿수 더하기
			digits++; num *= 10;
		}
		// 출력
		System.out.print(output);
	}
}