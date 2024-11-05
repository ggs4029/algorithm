// 백준 8394번
// 회의가 끝났고, 이제 악수를 하는 시간이다. 모든 사람은 직사각형 탁자 하나의 한 면에 앉아있다.
// 자리를 벗어나지 않고 악수를 하는 방법의 수는 총 몇 가지일까?
// 각 사람들은 자신의 왼쪽이나 오른쪽에 있는 사람들과 악수를 할 수 있다.
// 수가 매우 커질 수 있기 때문에, 마지막 자리만 출력
// 방법---------------------
// 첫 줄에 회의에 참석한 사람 수 n이 입력으로 주어짐.
// 1. 오른쪽 사람과 악수하는 경우		-> dp[n-2]
// 2. 오른쪽 사람과 악수하지 않는 경우	-> dp[n-1]
// 즉, dp[n] = dp[n-1] + dp[n-2] -> 피보나치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr8394 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// dp
		int[] dp = new int[n+1];
		dp[1] = 1;										// 맨왼쪽 두명이 악수 안하는 경우
		dp[2] = 2;										// 맨왼쪽 두명이 악수 하는 경우
		for(int i=3; i<=n; i++)
			dp[i] = (dp[i-1] + dp[i-2]) % 10;			// 마지막 자리만 저장
		// 출력
		System.out.print(dp[n]);
	}
}