// 백준 2533번
// 친구 관계 트리가 주어지면 모든 개인이 새로운 아이디어를 수용하기 위하여
// 필요한 최소 얼리 어답터의 수를 구하는 문제.
// 친구 관계 그래프가 트리는 모든 두 정점 사이에 이들을 잇는 경로가 존재하면서 사이클이 존재하지 않는다.
// 방법---------------------
// 첫 줄에 정점 개수 n이 주어짐.
// 다음 줄부터 n-1줄에 걸쳐 트리의 에지 u, v가 주어진다.
// dfs 메소드 구현해서 사용.
// 현 노드가 얼리어답터면 자식 노드는 얼리어답터일수도 아닐수도 있음.
// 그래프 탐색하고 루트의 dp값 비교해 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pr2533 {
	public static int[][] dp;
	public static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			tree[i] = new ArrayList<>();
		for(int i=1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v); tree[v].add(u);
		}
		// dp
		dp = new int[n+1][2];
		// dfs 호출
		dfs(1, -888484);
		// 출력
		System.out.print(Math.min(dp[1][0], dp[1][1]));			// 루트가 얼리어답터인 경우, 아닌 경우 비교
	}

	// dfs 메소드
	public static void dfs(int start, int parent) {
		dp[start][0] = 0;
		dp[start][1] = 1;										// 본인이 얼리어답터인 겨웅
		for(int i : tree[start]) {
			if(i != parent) {
				dfs(i, start);
				dp[start][0] += dp[i][1];
				dp[start][1] += Math.min(dp[i][0], dp[i][1]);	// 본인이 얼리어답터 -> 자식 둘 다 가능
			}
		}
	}
}