// 백준 1463번
// 정수 N을 연산 세 개를 사용해 1로 만들려고 할때 연산을 사용하는 횟수의 최솟값을 출력하는 문제
// 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
// 2. X가 2로 나누어 떨어지면, 2로 나눈다.
// 3. 1을 뺀다.
// 방법---------------------
// 첫 줄에 N을 입력 받음.
// dp로 구현해 최소 연산값을 출력.
// 주의! - 연산 3이 연산 1,2의 if문보다 위에있어야함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1463 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		// dp이용해 연산 최솟값 찾기
		int[] dp = new int[N+1];
		dp[1] = 0; 								// 초기값 설정
		for(int i=2; i<=N; i++) {
			// 연산 3
			dp[i] = dp[i-1] + 1;
			// 연산 1
			if(i%3==0)
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			// 연산 2
			if(i%2==0)
				dp[i] = Math.min(dp[i], dp[i/2]+1);
		}
		// 출력
		System.out.print(dp[N]);
	}
}