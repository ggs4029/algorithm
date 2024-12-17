// 백준 15666번
// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 문제.
// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.
// 고른 수열은 비내림차순이어야 한다.
// 수열은 사전 순으로 증가하는 순서로 출력.
// 방법---------------------
// 첫째 줄에 n과 m이 주어짐.
// dfs를 이용해 풀이.
// 중복 가능하고 비내림차순인 점에 주의.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr15666 {
	public static int n, m;
	public static int[] visited;
	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		visited = new int[n];
		num = new int[m];
		input = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			visited[i] = Integer.parseInt(input[i]);
		// 정렬
		Arrays.sort(visited);
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
		int tmp2 = -1557;
		for(int i=s; i<n; i++) {
			int now = visited[i];
			if(tmp2!=now) {
				num[tmp] = visited[i];
				tmp2 = now;
				dfs(tmp+1, i, sb);					// 자기 자신 포함하여 재귀 탐색
			}
		}
	}
}