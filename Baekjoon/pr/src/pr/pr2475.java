// 백준 2475번
// 간단한 검증수 구하기
// 방법---------------------
// 첫 줄에 고유번호 5자리를 입력받고
// 검증수(검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지)
// 를 구한 뒤 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine().replace(" ", "");
		int sum = 0;
		for(int i=0; i<input.length(); i++) {
			int x = input.charAt(i)-'0';
			sum = sum + x*x;
		}
		//출력
		System.out.print(sum%10);
	}
}