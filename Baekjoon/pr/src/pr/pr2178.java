// 백준 2178번
// 미로 탐색 문제.
// 1,1 에서 출발해서 n,m까지 이동할 떄 지나야 하는 최소 칸 수 구하는 문제.
// 방법---------------------
// 첫 줄에 n과 m을 입력 받음.
// 다음 줄부터 n줄에 걸쳐 지도를 입력 받는다.
// bfs메소드 구현해 map에 거리 저장하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr2178 {
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int[][] map;
	public static int n, m;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<m; j++)
				map[i][j] = input.charAt(j) - '0';
		}
		visited = new boolean[n][m];
		visited[0][0] = true;
		// bfs
		bfs(0, 0);
		// 출력
		System.out.print(map[n-1][m-1]);
	}

	// bfs 메소드
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tmpX = tmp[0];
			int tmpY = tmp[1];
			// 이동
			for(int i=0; i<4; i++) {
				int nX = tmpX + dx[i];
				int nY = tmpY + dy[i];
				if(nX<0 || nY<0 || nX>=n || nY>=m || visited[nX][nY] || map[nX][nY]==0)	// 방뭄했거나 벽이면
				    continue;
				q.add(new int[] {nX, nY});
				map[nX][nY] = map[tmpX][tmpY] + 1;										// 거리 +1
				visited[nX][nY] = true;													// 방문
			}
		}
	}
}