// 백준 16195번
// 정수 n과 m이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성.
// 단, 사용한 수의 개수는 m개 이하.
// 방법---------------------
// 첫 줄에 테스트 케이스의 수 t가 주어짐.
// 테스트 케이스는 n과 m 한 줄로 이루어져 있음.
// dp값 구해 출력.
// dp[n][m] = m개의 수를 사용해서 n을 만들 수 있는 방법의 수.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr16195 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// dp
		long[][] dp = new long[1001][1001];
		dp[0][0] = 1;
		for(int i=1; i<=1000; i++) {
			for(int j=1; j<=i; j++) {
				if(i-1>=0)
					dp[i][j] += dp[i-1][j-1];
				if(i-2>=0)
					dp[i][j] += dp[i-2][j-1];
				if(i-3>=0)
					dp[i][j] += dp[i-3][j-1];
				dp[i][j] %= 1_000_000_009;
			}
		}
		// 누적합 구하기
		for(int i=1; i<=1000; i++) {
			for(int j=1; j<=i; j++)
				dp[i][j] = (dp[i][j] + dp[i][j-1]) % 1_000_000_009;
		}
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			sb.append(dp[n][m]).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}