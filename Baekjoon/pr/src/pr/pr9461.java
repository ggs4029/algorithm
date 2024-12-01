// 백준 5705번
// 파도반 수열에서 n이 주어지면 p(n)을 구하는 문제.
// 파도반 수열이 무엇인지는 문제에서 확인.
// 방법---------------------
// 첫째 줄에 테스트 케이스의 개수 t를 입력 받음.
// 각 테스트 케이스마다 n을 입력 받음.
// 찾은 규칙 dp[j] = dp[j-2] + dp[j-3] 이용해 dp(n)구하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			// dp
			long[] dp = new long[100+1];
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			for(int j=4; j<n+1; j++)
				dp[j] = dp[j-2] + dp[j-3];
			sb.append(dp[n]).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}