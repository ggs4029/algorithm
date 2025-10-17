// 백준 11722번
// 수열 a가 주어지면 가장 긴 감소하는 부분 수열의 길이를 구하는 문제.
// 방법---------------------
// 첫 줄에 수열 크기 n이 입력으로 주어짐.
// 둘째 줄에 수열이 주어짐.
// dp로 계산 - 원소 방문 시 기본 1로 dp초기화.
// 전의 원소들을 탐색하며 min값을 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11722 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		Integer[] dp = new Integer[n];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(input[i]);
		// dp - 가장 긴 감소하는 부분 수열 구하기
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {					// 전의 원소들 순회
				if(a[j]>a[i] && dp[i]<dp[j]+1)
					dp[i] = dp[j] + 1;
			}
		}
		int output = -1557;
		for(int i=0; i<n; i++) {
		    if(dp[i] > output)
		        output = dp[i];
		}
		// 출력
		System.out.print(output);
	}
}