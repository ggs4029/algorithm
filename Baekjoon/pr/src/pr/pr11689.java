// 백준 11689번
// 자연수 n이 주어졌을 때, GCD(n, k) = 1을 만족하는 자연수 1 ≤ k ≤ n 의 개수를 구하는 문제
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// 오일러 피함수를 이용해 답을 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11689 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Long.parseLong(br.readLine());
		// 출력
		System.out.print(euler(n));
	}
	// 오일러 피 함수 - φ(x) 구하기
	public static long euler(long n) {
		long output = n;
		for(long i=2; i*i<=n; i++) {
			if(n%i == 0) {
				while(n%i == 0)
					n = n/i;
				output = output / i*(i-1);
			}
		}
		if(n > 1)
			output = output - output/n;
		return output;
	}
}