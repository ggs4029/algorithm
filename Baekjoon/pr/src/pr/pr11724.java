// 백준 11724번
// 방향 없는 그래프가 주어지면, 연결 요소의 개수를 구하는 문제.
// 방법---------------------
// 첫 줄에 정점의 개수 n, 간선의 개수 m이 주어짐.
// 다음줄부터 m줄에 걸쳐 간선의 양 끝점 u, v가 주어짐.
// 연결 요소의 개수 구하기 = dfs의 호출 개수 세기 -> for문 돌려가며 dfs
// 주의! - 이미 방문했는지 안했는지 if문으로 구분해 잘 세어야함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class pr11724 {

	public static ArrayList<Integer>[] list;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			list[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			String[] input2 = br.readLine().split(" ");
			int u = Integer.parseInt(input2[0]);
			int v = Integer.parseInt(input2[1]);
			list[u].add(v);								// 어디랑 연결되어 있는지 저장
			list[v].add(u);								//  		"
		}
		// 각 정점 리스트 정렬
		for(int i=1; i<=n; i++)
			Collections.sort(list[i]);
		// dfs 호출과 연결 요소 개수 구하기
		int sum = 0;
		visited = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				dfs(i);
				sum++;
			}
		}
		System.out.print(sum);
	}

	// dfs
	public static void dfs(int i) {
		// 방문
		visited[i] = true;
		// 연결된 정점 탐색
		for(int j : list[i]) {
			if(!visited[j])
				dfs(j);
		}
	}
}