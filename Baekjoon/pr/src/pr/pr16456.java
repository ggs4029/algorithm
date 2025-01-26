// 백준 14428번
// 어떤 섬을 보고 바로 그 다음 섬으로 갈 수 있음.
// 어떤 섬을 보고 한 섬을 건너뛰고 그 다음 섬으로 갈 수도 있음.
// 어떤 섬을 보고 그 이전 섬으로 갈 수 있음.
// 모든 n개의 섬을 보고 싶고 한번 갔던 섬에 다시 가고 싶지 않을 때,
// n개의 섬들이 있을 때 라가가 하와이를 여행하는 방법이 모두 몇 가지인지 구해 보는 문제.
// 방법---------------------
// 첫 줄에 열도의 섬 개수 n을 입력 받고
// dp 이용해 dp[n]을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr16456 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// dp
		long[] dp = new long[n+1];
		dp[0] = 1;
		if(n>=1)
			dp[1] = 1;
		if(n>=2)
			dp[2] = 1;
		for(int i=3; i<=n; i++) {
			dp[i] += dp[i-1];				// 다음 섬 가기
			if(n>=3)
				dp[i] += dp[i-3];			// 이전 섬으로 간 경우
			dp[i] %= 1_000_000_009;
		}
		// 출력
		System.out.print(dp[n]);
	}
}