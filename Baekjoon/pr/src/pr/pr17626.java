// 백준 17626번
// 자연수 n이 주어질 때, 합이 n과 같게 되는 제곱수들의 최소 개수를 출력하는 문제
// 방법---------------------
// 첫 줄에 자연수 n을 입력 받음.
// dp 이용해 계산.
// dp[i] = i에 1부터 제곱수를 빼가며 비교했을 때 제일 작은 dp값에 1을 더한 것.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17626 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// dp
		long[] dp = new long[n+1];
		dp[0] = 0; dp[1] = 1;						// 초기 설정
		for(int i=2; i<=n; i++) {
			long tmp = 50000;						// n<=50000이므로
			for(int j=1; j*j<=i; j++)
				tmp = Math.min(dp[i-j*j], tmp); 	// i에 1부터 제곱수를 빼가며 비교
			dp[i] = tmp+1;
		}
		// 출력
		System.out.print(dp[n]);
	}
}