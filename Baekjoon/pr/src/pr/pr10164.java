// 백준 10164번
// 격자에 관한 정보가 주어질 때 로봇이 문제에서 설명한 두 조건을 만족하면서
// 이동할 수 있는 서로 다른 경로가 총 몇 개나 되는지 찾는 문제.
// 방법---------------------
// 첫 줄에 격자의 행과 열의 수 n, m 그리고 ○로 표시된 칸의 번호를 나타내는 정수 k가 주어짐.
// dp로 계산.
// dp[k앞] * dp[k뒤] 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		// dp
		long[][] dp = new long[16][16];
		dp[0][1] = 1;
		for(int i=1; i<=15; i++) {
			for(int j=1; j<=15; j++)
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
		}
		// 출력
		if(k==0)
			System.out.print(dp[n][m]);
		else {
			int tmp1 = (k-1) / m + 1;
			int tmp2 = (k-1) % m + 1;
			System.out.print(dp[tmp1][tmp2] * dp[n-tmp1+1][m-tmp2+1]);
		}
	}
}