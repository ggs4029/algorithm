// 백준 23304번
// 트럼프 카드에서 n장 뽑을 때 나오는 포카드 조합의 수 구하는 문제.
// 방법---------------------
// 첫 줄에 n 입력 받음.
// dp[i][j] = i개의 카드중 j개를 선택하는 경우
// 오답노트------------------
// 포함배제 - 중복 거르기 해야함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr16565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[52+1][52+1];
		for(int i=0; i<=52; i++)
			dp[i][0] = 1;
		// dp
		for(int i=1; i<=52; i++) {
			for(int j=1; j<=52; j++)
				dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
		}
		// 포카드 조합 수 세기
		int output = 0;
		for(int i=1; i<=13; i++) {
			if(n-4*i<0)												// 4*i -> 포카드 선택시 필요한 최소치
				break;
			int tmp = (dp[52-i*4][n-i*4] * dp[13][i]) % 10007;		// i개의 포카드 경우의 수 * 나머지 카드 경우의 수
			// 중복 거르기
			if(i%2 == 0)
				output = (output - tmp + 10007) % 10007;
			else
				output = (output + tmp) % 10007;
		}
		// 출력
		System.out.print(output);
	}
}