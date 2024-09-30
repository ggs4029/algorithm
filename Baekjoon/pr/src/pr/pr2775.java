// 백준 2775번
// 아파트 k층n호에는 몇명이 사나 구하는 문제
// 1 ≤ k, n ≤ 14
// 방법---------------------
// 첫 줄에 test case의 수 t를 입력 받고
// 다음 줄부터 2t줄에 걸쳐 k와 n을 한줄씩 입력 받고
// 해당 집의 거주민 수를 출력.
// 주의!- 시간재한 -> 재귀함수를 이용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2775 {

	int[][] apart = new int[15][15];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int x=0; x<t; x++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			// 출력
			System.out.println(solve(k, n));
		}
	}

	public static int solve(int k, int n) {
		// 0층 n호에는 항상 n명이 살고있음
		if(k==0)
			return n;
		// k층 1호에는 항상 1명이 살고있음
		if(n==1)
			return 1;
		// k층 n호에는 항상 k-1층의 1~n호의 사람들을 다 합친거만큼 살고있음
		return solve(k - 1, n) + solve(k, n - 1);
	}
}