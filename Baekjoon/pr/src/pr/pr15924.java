// 백준 15924번
// 구사과가 선물을 가져가는 경로의 수를 구하는 문제.
// 지도의 각 칸에는 E, S, B중의 한 문자가 쓰여져 있는데, 구사과는 이 문자를 이용해서 이동.
// 구사과의 위치를 모르지만, 구사과가 이동을 시작하는 위치와 관계없이 최종 목적지는 항상 (N, M).
// 선물을 (N, M)에 배치해서 구사과가 항상 선물을 가져갈 수 있게 할 작정.
// 방법---------------------
// 첫 줄에 지도의 세로가로 크기 n, m이 주어짐.
// 다음 줄부터 n줄에 걸쳐 구사과가 있는 곳의 지도가 주어진다.
// E, S, B에 따라 이동하도록 dp짜서 mod 처리해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15924 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] map = new char[n+1][m+1];
		for(int i=1; i<=n; i++) {
			String input = br.readLine();
			for(int j=1; j<=m;  j++)
				map[i][j] =input.charAt(j-1);

		}
		// dp
		long[][] dp = new long[n+1][m+1];
		long mod = 1_000_000_009;
		for(int i=1; i<=n; i++) {				// dp값 초기화
			for(int j=1; j<=m; j++)
				dp[i][j] = 1;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(map[i][j]=='E') {
					dp[i][j+1] += dp[i][j] % mod;
				}
				else if(map[i][j]=='S') {
					dp[i+1][j] += dp[i][j] % mod;
				}
				else if(map[i][j]=='B') {
					dp[i+1][j] += dp[i][j] % mod;
					dp[i][j+1] += dp[i][j] % mod;
				}
			}
		}
		// 출력
		System.out.print(dp[n][m] % mod);
	}
}