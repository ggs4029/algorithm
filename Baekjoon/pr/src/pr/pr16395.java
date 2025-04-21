// 백준 16395번
// n과 k가 주어지면 파스칼의 삼각형에 있는 n번째 행 k번째 수를 출력하는 문제.
// 방법---------------------
// 첫 줄에 n과 k를 입력 받음.
// 파스칼의 삼각형 구현해서 dp[n][k]출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr16395 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// dp
		int[][] dp = new int[n + 1][n + 1];
		for(int i=1; i<=n; i++) {
			dp[i][1] = 1; dp[i][i] = 1;						// 각 줄 시작과 끝
			for(int j=2; j<i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		// 출력
		System.out.print(dp[n][k]);
	}
}