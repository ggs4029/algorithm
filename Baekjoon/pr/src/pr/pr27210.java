// 백준 27210번
// 사당에 돌상 n개가 있음.
// 각 돌상은 왼쪽 또는 오른쪽을 바라보고 서있다.
// 창영이는 연속한 몇 개의 돌상에 금칠을 하여 궁극의 깨달음을 얻고자 한다.
// 궁극의 깨달음을 얻기 위해서는 가능한 한 많은 금색 돌상들이 같은 방향을 바라보아야 한다.
// 방향이 다른 돌상은 깨달음에 치명적이다.
// 깨달음의 양은 |왼쪽 바라보는 돌상 - 오른쪽 바라보는 돌상| 임.
// 최대 깨달음의 양 구하기.
// 방법---------------------
// 첫 줄에 돌상 수 n이 주어지고
// 다음 줄에 돌상들이 바라보고 있는 방향이 한줄에 주어짐.
// 왼쪽이 1 오른쪽이 2
// dp로 깨달음 누적합 구하고
// 왼쪽 연속되는 부분이랑 오른쪽 연속되는 부분
// 두개의 차이가 최대가 되게 값 구하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr27210 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];									// 누적합 저장
		int[] rock = new int[n+1];									// 방향 저장
		int output = 0;
		int min = 0, max = 0; 										// 최소 최대 누적합
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			rock[i] = Integer.parseInt(st.nextToken());
			// 최대 깨달음 구하기
			if(rock[i] == 1)										// 왼쪽 보면
				dp[i] = dp[i-1] + 1;
			else													// 오른쪽은
				dp[i] = dp[i-1] - 1;								// 나중에 -계산으로 들어가므로 -1로 저장
			min = Math.min(min, dp[i]);
			max = Math.max(max, dp[i]);
			output = Math.max(output, Math.abs(dp[i] - min));
			output = Math.max(output, Math.abs(dp[i] - max));
		}
		// 출력
		System.out.print(output);
	}
}