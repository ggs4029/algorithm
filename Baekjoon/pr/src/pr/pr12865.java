// 백준 12865번
// 배낭 문제.
// 방법---------------------
// 첫 줄에 물품 수 n, 버틸 수 있는 무게 k가 주어짐.
// 두 번째 줄부터 n개의 줄에 거쳐 각 물건의 무게 w와 해당 물건의 가치 v가 주어짐.
// dp로 해결.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] w = new int[n];
		int[] v = new int[n];
		for(int i=0; i<n;  i++) {
			input = br.readLine().split(" ");
			w[i] = Integer.parseInt(input[0]);
			v[i] = Integer.parseInt(input[1]);
		}
		// dp
		int[][] dp = new int[n+1][k+1];
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=k; j++) {
				dp[i][j] = dp[i-1][j];													// 물품 선택 x
				if(w[i-1]<=j)															// 물품 선택 가능한 경우
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i-1]] + v[i-1]);			// 최대 가치 고르기 (선택 or 선택x)
			}
		}
		// 출력
		System.out.print(dp[n][k]);
	}
}