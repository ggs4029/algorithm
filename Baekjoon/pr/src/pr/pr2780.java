// 백준 2780번
// 비밀번호를 만들 때 사용했던 조건이 적힌 쪽지를 보고
// 가능한 비밀번호의 전체 개수를 구하는 문제.
// 조건과 비밀번호 장치 모양은 문제 참조.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받고
// 각 테스트 케이스마다 비밀번호의 길이 n을 입력 받는다.
// dp[i][j] = j로 끝나는 길이가 i인 비밀번호 개수
// n입력 받고 dp[n][]의 sum 출력.
// 오답노트------------------
// sum 출력할 때 모드로 나누기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2780 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int t = Integer.parseInt(br.readLine());
		int[][] dp = new int[1000+1][10];
		for(int i=0; i<10; i++)
			dp[1][i] = 1;
		// dp
		for(int i=2; i<=1000; i++) {
			// 길이 i고 0~9로 끝나는 비밀번호 개수 구하기
			int mod = 1_234_567;
			dp[i][0] = dp[i-1][7] % mod;
			dp[i][1] = (dp[i-1][2] + dp[i-1][4]) % mod;
			dp[i][2] = (dp[i-1][1] + dp[i-1][3] + dp[i-1][5]) % mod;
			dp[i][3] = (dp[i-1][2] + dp[i-1][6]) % mod;
			dp[i][4] = (dp[i-1][1] + dp[i-1][5] + dp[i-1][7]) % mod;
			dp[i][5] = (dp[i-1][2] + dp[i-1][4] + dp[i-1][6] + dp[i-1][8]) % mod;
			dp[i][6] = (dp[i-1][3] + dp[i-1][5] + dp[i-1][9]) % mod;
			dp[i][7] = (dp[i-1][0] + dp[i-1][4] + dp[i-1][8]) % mod;
			dp[i][8] = (dp[i-1][5] + dp[i-1][7] + dp[i-1][9]) % mod;
			dp[i][9] = (dp[i-1][6] + dp[i-1][8]) % mod;
		}
		// 입력2
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			for(int j=0; j<10; j++)
				sum += dp[n][j];
			sb.append(sum % 1_234_567).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}