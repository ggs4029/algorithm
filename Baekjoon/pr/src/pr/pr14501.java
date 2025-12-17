// 백준 14501번
// 상담원으로 일하던 중에 n+1일 후에 퇴사 할거임.
// 남은 n일 동안 최대한 많은 상담을 하려함.
// 상담은 걸리는 시간 ti랑 받는 금액 pi로 이루어져 있음.
// 상담을 적절히 해서 얻을 수 있는 최대 수익을 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어지고
// 다음 줄부터 n줄에 걸쳐 ti, pi가 한줄에 주어짐.
// t랑 p 배열 만들어서 저장하고
// dp[n] = n일차에 얻을 수 있는 최대 수익으로 잡고
// 상담이 끝나는 날이 퇴사날을 넘기지 않도록 주의하며 dp[n]의 값을 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n];
		int[] p = new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		// dp
		int[] dp = new int[n+1];
		for(int i=0; i<n; i++) {
			if(i+t[i] <= n)											// 퇴사 전에 상담 끝나야함
				dp[i + t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]);
			dp[i+1] = Math.max(dp[i], dp[i+1]);
		}
		// 출력
		System.out.print(dp[n]);
	}
}