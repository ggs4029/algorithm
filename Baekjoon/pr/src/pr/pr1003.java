// 백준 1003번
// fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 문제
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받고
// 다음줄부터 t줄에 걸쳐 n을 입력 받음.
// dp 구현 그 안에 0과 1이 출력되는 횟수를 구해 테스트 케이스마다 한 줄로 출력.
// 주의! - 재귀함수로 구현시 시간초과, dp로 구현해야함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int t = Integer.parseInt(br.readLine());
		int[] input = new int[t];
		for(int i=0; i<t; i++)
			input[i] = Integer.parseInt(br.readLine());
		// 최대 값 찾기
		int[] input2 = Arrays.copyOf(input, t);
		Arrays.sort(input2);
		int max = input2[t-1];
		// dp로 0, 1 출력 횟수 찾기
		long[][] dp = new long[40 + 1][2];
		dp[0][0] = 1; // fibonacci(0)의 경우 - 0 출력횟수
		dp[0][1] = 0; // 				   - 1 출력횟수
		dp[1][0] = 0; // fibonacci(1)의 경우 - 0 출력횟수
		dp[1][1] = 1; //				   - 1 출력횟수
		for(int i=2; i<=max; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0]; // 0의 출현 횟수
			dp[i][1] = dp[i-1][1] + dp[i-2][1]; // 1의 출현 횟수
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int n : input) {
			sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
		}
		System.out.print(sb.toString());
	}
}