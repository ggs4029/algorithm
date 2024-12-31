// 백준 4811번
// 약이 n개 담긴 병이 있음. 매일 매일 약 반알을 먹을거임.
// 첫째 날에 병에서 약 하나를 꺼낸다. 그 다음, 그 약을 반으로 쪼개서 한 조각은 먹고, 다른 조각은 다시 병에 넣음.
// 다음 날부터 종수는 병에서 약을 하나 꺼낸다. (약은 한 조각 전체 일 수도 있고, 쪼갠 반 조각 일 수도 있다)
// 반 조각이면 약을 먹고, 아니면 반 쪼개서 한 조각 먹고, 다른 조각은 다시 병에 넣음.
// 한 조각 꺼낸 날에는 w를, 반 조각을 꺼낸 날에는 편지에 h를 보낼거임.
// 총 2n일이 지나면 길이가 2n인 문자열이 만들어지게 되는데 이때, 가능한 서로 다른 문자열의 개수는 총 몇 개일지 구하는 문제.
// 방법---------------------
// 매 줄마다 병에 들어있는 약의 개수 n을 입력 받음.
// 입력의 마지막 줄에는 0이 주어짐.
// dp[i][j] = i개의 온전한 알약과 j개의 반 알약을 먹었을 때의 가능한 문자열 경우의 수.
// dp 구해서 출력.
// 주의 사항-----------------
// 반 알약이 더 많으면 x - 반 알약은 온전한 알약에서 나오는거기 때문.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr4811 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// dp
		long[][] dp = new long[31][31];
		for(int i=0; i<=30; i++)
			dp[i][0] = 1;												// 빈 알약 없으면 온전한 알약을 쪼개 먹기
		for(int one=1; one<=30; one++) {
			for(int half=1; half<=30; half++) {
				if(half>one)											// 반 알약이 더 많으면 x
					continue;
				else
					dp[one][half] = dp[one-1][half] + dp[one][half-1];	// 어떤 알약 먹을지 선택
			}
		}
		// 입력
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			sb.append(dp[n][n]).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}