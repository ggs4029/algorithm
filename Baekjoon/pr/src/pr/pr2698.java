// 백준 2698번
// 0과 1로 이루어진 수열 S가 있다. S의 첫 수는 s1이고, 마지막 수는 sn이다.
// 수열 S의 크기 n과 k가 주어졌을 때, 인접한 비트의 개수가 k인 수열 S의 개수를 구하는 문제. (수열 S에서 인접한 1의 개수를 구하는 문제)
// 예를 들어, n이 5이고, k가 2이면, 수열 S가 될 수 있는 수열은 다음과 같이 6가지가 있다.
// 11100, 01110, 00111, 10111, 11101, 11011
// 방법---------------------
// 첫 줄에 테스트 케이스의 수 t가 주어짐.
// 각 테스트 케이스는 한 줄이고 n과 k가 주어진다.
// dp[a][b][c] = a개의 비트, 인접한 비트 수가 b, 끝으로 끝나는 비트가 c
// 각 테스트 케이스에 대해 dp 계산해서 끝이 0인 경우와 1인 경우를 더해 출력.
// 오답노트------------------
// dp[i][j][1] = dp[i-1][j-1][1] + dp[i-1][j][0] 에 대해
// 바로 앞이 1이면 j-1번 인접하고 1로 끝난 경우의 수를 더해야 인접 비트 수 +1 되서 j번되고
// 바로 앞이 0이면 j번 인접하고 0으로 끝난 경우의 수에 대해서 더해줘야 함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2698 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		// dp
		long[][][] dp = new long[100+1][100+1][2];
		dp[1][0][0] = 1; dp[1][0][1] = 1;
		for(int i=2; i<=100; i++) {
			dp[i][0][0] = dp[i-1][0][0] + dp[i-1][0][1];		// 끝이 0이면 바로 앞이 1이어도 ok
			dp[i][0][1] = dp[i-1][0][0];						// 끝이 1이면 바로 앞자리가 0이어야 ok
			for(int j=1; j<=i-1; j++) {
				dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1];	// 끝이 0이면 바로 앞이 1이어도 ok
				dp[i][j][1] = dp[i-1][j-1][1] + dp[i-1][j][0];	// 오답노트
			}
		}
		// 입출력
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			sb.append(dp[n][k][0] + dp[n][k][1]).append("\n");
		}
		System.out.print(sb.toString().trim());
	}
}