// 백준 1695번
// 한 수열이 주어졌을 때, 이 수열에 최소 개수의 수를 끼워 넣어 팰린드롬을 만들려고 함.
// 최소 몇 개의 수를 끼워 넣으면 되는지 출력하는 문제.
// 방법---------------------
// 첫 줄에 수열의 크기 n이 주어짐.
// 다음 줄에 n개의 수들이 주어짐.
// dp[i][j] = i~j까지를 팰린드롬으로 만들기 위해 필요한 삽입 횟수의 최솟값
// 메소드로 구현해 재귀로 삽입 횟수의 최솟값들을 구한다.
// 끝 값끼리 비교해서 다르면 왼or오에 삽입하고 최솟값 비교.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1695 {
	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// dp
		int[][] dp = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				dp[i][j] = -1557;
		}
		// 출력
		System.out.print(cal(dp, 0, n-1));
	}

	// 몇 개의 수를 끼워 넣어야 하는지 계산하는 메소드
	public static int cal(int[][] dp, int l, int r) {
		if(l > r)
			return 0;
		if(dp[l][r] != -1557)											// 이미 계산 했으면
			return dp[l][r];
		if(num[l] == num[r])											// 끝 값 같으면
			dp[l][r] = cal(dp, l+1, r-1);								// 끝 값 제외하고 다시 계산
		else {															// 끝 값 다르면
			int left = cal(dp, l+1, r);
			int right = cal(dp, l, r-1);
			dp[l][r] = Math.min(left, right) + 1;						// 왼or오 삽입
		}
		return dp[l][r];
	}
}