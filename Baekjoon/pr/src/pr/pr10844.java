// 백준 10844번
// n이 주어지면, 길이가 n인 계단 수가 총 몇개 있는지 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 이차원 배열 dp로 문제 풀기.
// dp[n][m] = n자리인 m으로 시작하는 계단 수의 개수
// 오답노트------------------
// 1로 시작하는 계단 수의 개수를 구하려면
// 0으로 시작하는 계단 수의 개수도 구해야함.
// 마찬가지로 8로 시작하는 계단 수의 개수 구하기 이ㅜ해
// 9로 시작하는 계단 수의 개수도 구하기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// dp
		int[][] dp = new int[n+1][9+1];
		int mod = 1_000_000_000;
		int output = 0;
		for(int i=0; i<=9; i++)
			dp[1][i] = 1;														// 길이가 1인 계단 수는 다 한개
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				if(j == 0)														// 0으로 시작하는 경우
					dp[i][j] = dp[i-1][1] % mod;
				else if(j == 9)													// 9로 시작하는 경우
					dp[i][j] = dp[i-1][8] % mod;
				else															// 1~8로 시작하는 경우
					dp[i][j] = (dp[i-1][j-1] % mod + dp[i-1][j+1] % mod) % mod;
			}
		}
		for(int i=1; i<=9; i++) {
			output += dp[n][i];
			output %= mod;
		}
		// 출력
		System.out.print(output % mod);
	}
}