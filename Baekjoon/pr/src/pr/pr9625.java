// 백준 9625번
// 기계를 발견했을 때, 화면에는 a만 표시되어져 있었다.
// 버튼을 누를 때마다 화면의 모든 b는 ba로 바뀌고, a는 b로 바뀐다는 사실을 알게되었다.
// 버튼 k번 눌렀을 때 화면에 a와 b가 몇개인지 구하는 문제.
// 방법---------------------
// 첫 줄에 k를 입력 받음.
// dp[0][j] = 버튼 j번 눌렀을 때의 a 개수
// dp[1][j] = 버튼 j번 눌렀을 때의 b 개수
// 둘 다 피보나치 수열을 따르고 있음.
// 값 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class pr9625 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int k = Integer.parseInt(br.readLine());
		// dp
		int[][] dp = new int[2][46];
		dp[1][1] = 1;
		dp[0][2] = 1;
		dp[1][2] = 1;
		for(int i=3; i<=k; i++) {
			dp[0][i] = dp[0][i-1] + dp[0][i-2];
			dp[1][i] = dp[1][i-1] + dp[1][i-2];
		}
		// 출력
		System.out.print(dp[0][k] + " " + dp[1][k]);
	}
}