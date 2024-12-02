// 백준 11726번
// 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 문제.
// 방법---------------------
// 첫째 줄에 n이 주어짐.
// dp규칙 dp[i] = dp[i-1] + dp[i-2]
// dp[n]을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// dp
		long[] dp = new long[1000+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<n+1; i++)
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		// 출력
		System.out.print(dp[n]);
	}
}