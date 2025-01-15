// 백준 1932번
// 맨 위층부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때,
// 이제까지 선택된 수의 합이 최대가 되는 경로에 있는 수의 합을 구하는 문제.
// 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
// 방법---------------------
// 첫 줄에 삼각형의 크기 n을 입력 받고
// 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어짐.
// dp 이용해 맨 아래층에서 부터 큰 수를 더해가며 dp 채워나감.
// 막 줄부터 순회하며 최댓값 찾아 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++)
				num[i][j] = Integer.parseInt(st.nextToken());
		}
		// dp
		int[][] dp = new int[n+1][n+1];
		dp[1][1] = num[1][1];
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				if(j==1)														// 왼쪽 끝이면 바로 위 선택
					dp[i][j] = dp[i-1][j] + num[i][j];
				else if(j==i)													// 오른쪽 끝이면 바로 위 선택
					dp[i][j] = dp[i-1][j-1] + num[i][j];
				else															// 그 외는 좌우 비교
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + num[i][j];
			}
		}
		// 최댓값 출력
		int output = 0;
		for(int i=1; i<=n; i++)
			output = Math.max(dp[n][i], output);
		System.out.print(output);
	}
}