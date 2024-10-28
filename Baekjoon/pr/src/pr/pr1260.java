// 백준 1260번
// 그래프를 dfs와 bfs로 탐색한 결과를 출력하는 문제.
// 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문.
// 방법---------------------
// 첫 줄에 정점의 개수 n, 간선의 개수 m, 탐색을 시작할 정점의 번호 v를 입력 받는다.
// 다음 줄부터 m줄에 걸쳐 간선이 연결하는 두 정점의 번호들을 입력 받는다.
// 탐색 가능 정점이 여러개면 작은 것 먼저 방문한다 했으므로 각 정점의 리스트를 정렬하고 시작.
// dfs, bfs 돌리고 방문 순서대로 찍어 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class pr1260 {

	public static ArrayList<Integer>[] list;
	public static boolean[] visited1;
	public static boolean[] visited2;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int v = Integer.parseInt(input[2]);
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			list[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			String[] input2 = br.readLine().split(" ");
			int tmp = Integer.parseInt(input2[0]);
			int tmp2 = Integer.parseInt(input2[1]);
			list[tmp].add(tmp2);								// 어디랑 연결되어 있는지 저장
			list[tmp2].add(tmp);								//  		"
		}
		// 각 정점 리스트 정렬
		for(int i=1; i<=n; i++)
			Collections.sort(list[i]);
		// dfs 호출과 출력
		visited1 = new boolean[n+1];
		System.out.println(dfs(v));
		// bfs 호출과 출력
		sb = new StringBuilder();
		visited2 = new boolean[n+1];
		System.out.print(bfs(v));
	}

	// dfs
	public static String dfs(int i) {
		// 방문
		visited1[i] = true;
		sb.append(i).append(" ");
		// 연결된 정점 탐색
		for(int j : list[i]) {
			if(!visited1[j])
				dfs(j);
		}
		return sb.toString();
	}
	// bfs
	public static String bfs(int i) {
		// 방문
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visited2[i] = true;
		// 연결된 정점 탐색
		while(!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp).append(" ");
			for(int j : list[tmp]) {
				if(!visited2[j]) {
					visited2[j] = true;
					q.offer(j);
				}
			}
		}
		return sb.toString();
	}
}