// 백준 9095번
// 정수 n이 주어지면 n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 문제
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어짐.
// 그 다음 t줄에 걸쳐 n을 입력 받음.
// dp로 구현해 n값에 맞는 방법의 수를 출력. (n<11 이므로 미리 싹 다 구해두기)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int t = Integer.parseInt(br.readLine());
		int[] input = new int[t];
		for(int i=0; i<t; i++)
			input[i] = Integer.parseInt(br.readLine());
		// dp이용해 연산 최솟값 찾기
		int[] dp = new int[10+1];
		dp[0] = 1; dp[1] = 1;
		dp[2] = 2; dp[3] = 4;
		for(int i=4; i<=10; i++)
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++)
			sb.append(dp[input[i]]).append("\n");
		System.out.print(sb.toString());
	}
}