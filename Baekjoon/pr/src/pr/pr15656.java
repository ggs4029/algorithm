// 백준 15656번
// n개의 자연수와 자연수 m이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 문제.
// n개의 자연수 중에서 m개를 고른 수열.
// 같은 수를 여러 번 골라도 됨.
// 수열은 사전 순으로 증가하는 순서로 출력.
// 방법---------------------
// 첫째 줄에 n과 m이 주어짐.
// 기본적인 dfs를 이용하되
// 사전 순으로 증가하는 순서로 출력 -> dfs 호출 전에 정렬하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr15656 {
	public static int n, m;
	public static int[] num, input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n];
		num = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			input[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(input);
		// dfs
		dfs(0, sb);
		// 출력
		System.out.print(sb.toString().trim());
	}

	// dfs
	private static void dfs(int depth, StringBuilder sb) {
		if(depth == m) {
			for(int i : num)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
			num[depth] = input[i];
			dfs(depth + 1, sb);
		}
	}
}