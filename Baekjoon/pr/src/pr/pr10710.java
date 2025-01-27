// 백준 10710번
// 실크로드를 건너려는데 이동 할 때마다 피로도가 쌓임.
// 각각의 날에 행동을 잘 선택하여 가능한 피로도를 적게해서 이동하고 싶을 때
// M 이내에 도시 N으로 이동할 때의 피로도 총합의 최소를 구하는 문제.
// 매일 이동 또는 대기 두가지 행동 중 하나를 할 수 있음.
// 자세한 내용은 문제 참조.
// 방법---------------------
// 첫 줄에 n과 m이 주어짐.
// 다음 줄부터 n줄에 걸쳐 도시사이의 거리들을 입력 받고
// m줄에 걸쳐 j일의 날씨 나쁨정도를 입력 받는다.
// dp[i][j] = j일까지 i번째 도시에 도착 + 최소 피로도 저장
// dp 이용해 최소 피로도 구해 출력.
// 오답노트------------------
// dp에 대충 큰 값 넣어두고 최솟값 찾아가는 과정에서
// tmp에 Long.MAX_VALUE 넣어버리면 너무 큰 값이라서 계산 제대로 안돌아가니까
// 대충 큰 수 넣고 돌리기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr10710 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] distance = new long[n + 1];
		long[] bad = new long[m + 1];
		for(int i=1; i<=n; i++)
			distance[i] = Long.parseLong(br.readLine());
		for(int i=1; i<=m; i++)
			bad[i] = Long.parseLong(br.readLine());
		// dp
		long[][] dp = new long[n+1][m+1];
		long tmp = 1557888484;								// 대충 큰 수, Long.MAX_VALUE -> 에러
		for(int i=0; i<=n; i++)
			Arrays.fill(dp[i], tmp);
		Arrays.fill(dp[0], 0);								// 초기 세팅
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++)
				dp[i][j] = Math.min(dp[i-1][j-1] + distance[i] * bad[j], dp[i][j-1]);
		}
		// 출력
		System.out.print(dp[n][m]);
	}
}