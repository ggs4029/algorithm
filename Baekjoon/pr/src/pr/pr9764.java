// 백준 9764번
// 양의 정수 N (1 ≤ N ≤ 2000)을 서로 다른 자연수의 합으로 나타내는 방법은 여러 가지가 있다.
// N이 주어졌을 때, 서로 다른 자연수의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스는 한 줄이고 n이 주어진다.
// dp[i][j] = i를 j개의 수를 사용해 만들 수 있는 경우의 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			// dp
			int[][] dp = new int[n+1][n+1];
			for(int j=0; j<=n; j++)
				dp[0][j] = 1;
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
					dp[j][k] = dp[j][k-1];  		// k없이 j 만들기
					if(j>=k) {						// k번째 수를 사용할 수 있는 경우
						dp[j][k] += dp[j-k][k-1];
						dp[j][k] %= 100999;
					}
				}
			}
			sb.append(dp[n][n]).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}