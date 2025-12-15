// 백준 2156번
// 포도주 시식회에는 두가지 규칙이 있음.
// 포도주 잔을 선택하면 그 잔에 있는거 다 마셔야하고 마신 후에는 원래 위치에 놓아야 함.
// 연속으로 놓인 3잔을 모두 마실 수는 없음.
// 1부터 n까지의 번호가 붙어있는 포도주 잔이 순서대로 테이블 위에 있고
// 포도주 잔 안에 들어있는 포도주의 양이 주어졌을 때
// 최대로 마실 수 있는 포도주의 양을 구하는 문제.
// 방법---------------------
// 첫 줄에 포도주 잔 개수 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 포도주의 양이 주어짐.
// dp사용해 풀이.
// dp[x] = x번 포도주 잔까지 있을때 마실 수 있는 포도주 양의 최댓값
// 가능한 경우의 수 oox, oxo, xoo 의 값을 비교해서 최댓값 구해 출력.
// --> xox는 최댓값을 구하는데 필요가 없는 경우임.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n + 1];
		for(int i=1; i<n+1; i++)
			num[i] = Integer.parseInt(br.readLine());
		// dp로 최댓값 구하기
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = num[1];
		if(n > 1)
			dp[2] = num[1] + num[2];
		for(int i=3; i<n+1; i++)
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + num[i], dp[i - 3] + num[i - 1] + num[i]));
		// 출력
		System.out.print(dp[n]);
	}
}