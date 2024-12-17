// 백준 11725번
// 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성.
// 방법---------------------
// 첫째 줄에 노드의 개수 n이 주어짐.
// 그 다음줄부터 n-1줄에 걸쳐 트리 상에서 연결된 두 정점이 주어짐.
// dfs를 돌며 각 노드의 부모 노드를 저장하고 차례대로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class pr11725 {
	public static int n;
	public static boolean[] visited;
	public static ArrayList<Integer> tree[];
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		parent = new int[n+1];
		tree = new ArrayList[n+1];
		for(int i=0; i<n+1; i++)
			tree[i] = new ArrayList<>();
		for(int i=0; i<n-1; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			tree[x].add(y);
			tree[y].add(x);
		}
		// dfs
		dfs(1);
		for(int i=2; i<parent.length; i++)
			sb.append(parent[i]).append("\n");
		// 출력
		System.out.println(sb.toString());
	}

	// dfs
	private static void dfs(int tmp) {
		visited[tmp] = true;							// 방문
		for(int i : tree[tmp]) {
			if(!visited[i]) {
				parent[i] = tmp;						// 각 노드의 부모를 저장
				dfs(i);
			}
		}
	}
}