// 백준 2193번
// n이 주어졌을 때, n자리 이친수의 개수를 출력하는 문제.
// 이친수가 무엇인지는 문제 참고.
// 방법---------------------
// 첫 줄에 문자열 n을 입력 받음.
// dp 이용해 점화식 찾아 풀이.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// dp - dp[i] = i자리 이하 이친수 개수
		long[] dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<=n; i++)
			dp[i] = dp[i-1] + dp[i-2];
		// 출력
		System.out.print(dp[n]);
	}
}