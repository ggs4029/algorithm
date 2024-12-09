// 백준 15650번
// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 문제.
// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 고른 수열은 오름차순이어야 한다.
// 방법---------------------
// 첫째 줄에 n과 m이 주어짐.
// dfs를 이용해 풀이.
// 오름차순이어야 하므로 dfs메소드에 변수 s(start)를 추가해서 다음에는 s+1부터 탐색하도록 구성.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15650 {
	public static int n, m;
	public static boolean[] visited;
	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		visited = new boolean[n];
		num = new int[m];
		// dfs
		StringBuilder sb = new StringBuilder();
		dfs(0, 0, sb);
		// 출력
		System.out.print(sb.toString());
	}

	// dfs
	private static void dfs(int tmp, int s, StringBuilder sb) {
		if(tmp==m) {
			for(int i : num)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=s; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				num[tmp] = i + 1;
				dfs(tmp + 1, i+1, sb);
				visited[i] = false;
			}
		}
	}
}