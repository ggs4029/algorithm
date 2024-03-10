// 백준 1535번
// 안녕
// 주어진 체력으로 기쁨의 최댓값을 구하는 dp문제
// 방법-----------------------------
// 문제의 입력 대로 입력 받고
// dp[99]를 구한 후 출력한다.
// --------------------------------
// dp[100]이 아니라 dp[99]를 구하는 이유
// -> 체력이 0이 되어도 아웃이므로.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1535 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[100];
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] L = new int[n];			// 체력
		int[] J = new int[n];			// 기쁨
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int x=0; x<n; x++) {
			L[x] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int x=0; x<n; x++) {
			J[x] = Integer.parseInt(st.nextToken());
		}
		// 최대 기쁨 구하기
		for(int x=0; x<n; x++) {
			for(int y=99; y>=L[x]; y--)
				dp[y] = Math.max(dp[y-L[x]] + J[x], dp[y]);
		}
		// 출력
		System.out.print(dp[99]);
	}
}