// 백준 14940번
// 지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.
// 문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.
// 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점.
// 2는 하나밖에 없음.
// 방법---------------------
// 첫 줄에 지도의 크기 n, m이 주어짐.
// 그 다음줄부터 n줄에 걸쳐 m개의 숫자가 주어짐.
// 목표지점 먼저 찾고 bfs를 돌며 목표지점까지의 거리 계산 후 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr14940 {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int n, m;
	public static int[][] map;
	public static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n][m];
		visited = new int[n][m];
		for(int i=0; i<n; i++) {
			String[] input2 = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(input2[j]);
				visited[i][j] = -1557;
			}
		}
		// 목표지점 찾기
		int x = -1557;
		int y = -1557;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==2) {
					x = i; y = j;
					break;
				}
			}
			if(x!=-1557)									// 이미 찾았으니까
				break;										// break
		}
		// bfs
		bfs(x, y);
		// 출력
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0)
					System.out.print("0 ");
				else if(visited[i][j]==-1557)
					System.out.print("-1 ");
				else
					System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}

	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		visited[x][y] = 0;																					// 시작지점
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int x1 = tmp[0];
			int y2 = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x1 + dx[i];
				int ny = y2 + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 0 && visited[nx][ny] == -1557) {
					visited[nx][ny] = visited[x1][y2] + 1; 													// 현재 위치에서 + 1
					q.add(new int[]{nx, ny});
				}
			}
		}
	}
}