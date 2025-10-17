// 백준 11055번
// 수열 a가 주어지면 그 수열의 증가하는 부분 수열 중에서
// 합이 가장 큰 것의 합을 구하는 문제.
// 방법---------------------
// 첫 줄에 수열 크기 n이 입력으로 주어짐.
// 둘째 줄에 수열이 주어짐.
// dp로 계산 - 원소 방문 시 기본 1로 dp를 초기화하는 대신 (원래 가장 긴 증가하는 부분 수열 코드)
// a[i]로 초기화하여 길이가 아닌 합에 대해 초기화 하도록 변경.
// dp 탐색하면서 구한 합이 최댓값.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		Integer[] dp = new Integer[n];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(input[i]);
		// dp - 증가하는 부분 수열 중 합이 가장 큰 것 구하기
		for(int i=0; i<n; i++) {
			dp[i] = a[i];
			for(int j=0; j<i; j++) {					// 전의 원소들 순회
				if(a[j]<a[i] && dp[i]<dp[j]+a[i])
					dp[i] = dp[j] + a[i];
			}
		}
		int output = 0;
		for(int i=0; i<n; i++) {
		    if(dp[i] > output)
		        output = dp[i];
		}
		// 출력
		System.out.print(output);
	}
}