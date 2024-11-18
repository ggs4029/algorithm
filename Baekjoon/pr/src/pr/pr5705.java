// 백준 5705번
// 학교로 가는 길에 육각형 타일로 덮인 경로를 따라 걸어갑니다.
// 타일은 일직선으로 배열되어 있으며, 각 타일은 연속적으로 번호가 매겨져 있습니다.
// Mary는 항상 웃는 얼굴이 있는 타일부터 시작합니다.
// 이 타일은 항상 경로의 시작에 존재하며, 번호가 1부터 시작하는 다른 타일들보다 우선적으로 밟습니다.
// Mary는 절대 뒤로 가거나 번호가 작은 타일을 다시 밟지 않습니다. 즉, 현재 타일보다 번호가 작은 타일로 되돌아가지 않습니다.
// Mary는 항상 옆에 있는 타일로만 이동합니다. 즉, 중간에 뛰어넘거나 건너뛰지 않고, 인접한 타일로만 걸어갑니다.
// Mary는 항상 가장 높은 번호가 매겨진 타일에서 끝을 맺습니다.
// 주어진 타일의 개수 n에 대해, Mary가 타일들을 밟으며 만들 수 있는 가능한 모든 다른 경로의 수를 구하는 문제.
// 방법---------------------
// 매 줄마다 n을 입력 받음.
// 0이 입력될 때까지 반복.
// 규칙 - dp[i] = dp[i-1] + dp[i-2]
// dp[n]값 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5705 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 경로 수 구하기(dp)
		long[] dp = new long[41];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<41; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		while(true) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			sb.append(dp[n]).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}