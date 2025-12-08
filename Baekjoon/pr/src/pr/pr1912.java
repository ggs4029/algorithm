// 백준 1912번
// n개의 정수로 된 임의의 수열이 주어지면
// 연속된 몇 개의 수를 선택해 구할 수 있는 합 중 가장 큰 합을 구하는 문제.
// 무조건 수는 한 개 이상 선택해야함.
// 방법---------------------
// 첫 줄에 n이 주어지고
// 다음 줄에 수열을 이루는 n개의 정수들을 입력 받음.
// dp를 사용해 연속합을 구하고 이전 연속합을 선택할지 이번꺼만 선택할지
// 큰 값을 고르고 최종적으로 제일 큰 값을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// dp로 연속합 구하기
		int[] dp = new int[n];
		int sum = num[0];
		dp[0] = num[0];
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(num[i], dp[i-1] + num[i]);		// 이전 연속합이랑 이번꺼 더해서 비교
			sum = Math.max(dp[i], sum);
		}
		// 출력
		System.out.print(sum);
	}
}