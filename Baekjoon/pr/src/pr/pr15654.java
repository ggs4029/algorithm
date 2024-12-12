// 백준 15654번
// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 문제.
// N개의 자연수 중에서 M개를 고른 수열.
// 방법---------------------
// 첫째 줄에 n과 m이 주어짐.
// dfs를 이용해 풀이.
// 정렬 먼저 하고 dfs.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr15654 {
	public static int n, m;
	public static boolean[] visited;
	public static int[] num;
	public static int[] num2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		visited = new boolean[n];
		num = new int[n];
		num2 = new int[n];
		String[] input2 = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(input2[i]);
		// 정렬
		Arrays.sort(num);
		// dfs
		StringBuilder sb = new StringBuilder();
		dfs(0, sb);
		// 출력
		System.out.print(sb.toString());
	}

	// dfs
	private static void dfs(int tmp, StringBuilder sb) {
		if(tmp==m) {
			for(int i : num2) {
				if(i!=0)
					sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				num2[tmp] = num[i];
				dfs(tmp + 1, sb);
				visited[i] = false;
			}
		}
	}
}