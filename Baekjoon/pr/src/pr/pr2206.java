// 백준 2206번
// 크기 n * m인 행렬인 맵이 있음.
// 0은 이동할 수 있고 1은 벽임.
// (1, 1)에서 (n, m)까지 최단 경로로 이동하려함.
// 이동 중에 벽을 부수고 이동하는게 좀 더 경로가 짧아지면 한 개 까지 부수고 이동 가능.
// 맵이 주어지면 최단 거리를 구하는 문제.
// 방법---------------------
// 첫 줄에 n, m을 입력 받음.
// 다음 줄부터 n줄에 걸쳐 각 줄마다 m개의 숫자들을 입력 받는다.
// visited를 3차원으로 만들고 visited[x][y][z] -> z = 벽을 뚫었으면 1 아직 안 뚫었으면 0
// Node클래스를 만들어 이동거리와 벽 부쉈는지 여부 또한 체크.
// bfs 메소드에서 벽을 이미 부쉈는지 체크하고 최단 거리를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr2206 {
	public static int n, m;
	public static int[][] map;
	public static boolean[][][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

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
		visited = new boolean[n][m][2];
		// 출력
		System.out.print(bfs());
	}

	// bfs 메소드
	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 1, false));
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			if(tmp.x==n-1 && tmp.y==m-1)										// 끝 도착하면
				return tmp.move;												// 이동거리 리턴
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(tmp.wall) {												// 이미 벽 부쉈으면
						if(map[nx][ny]==0 && !visited[nx][ny][1]) {
							visited[nx][ny][1] = true;
							q.offer(new Node(nx, ny, tmp.move+1, true));
						}
					}
					else {														// 아직 벽 안부쉈을 때
						if(map[nx][ny] == 1) {									// 벽이면
							visited[nx][ny][1] = true;							// 벽 부수고
							q.offer(new Node(nx, ny, tmp.move+1, true));
						}
						else if(!visited[nx][ny][0]){							// 벽 아니고 방문 안했으면
							visited[nx][ny][0] = true;
							q.offer(new Node(nx, ny, tmp.move+1, false));
						}
					}
				}
			}
		}
		return -1;
	}

	// 좌표와 이동거리, 벽을 부쉈는지 여부를 저장할 Node 클래스
	public static class Node {
		int x, y;
		int move;																// 이동한 거리
		boolean wall;															// 벽 부쉈는지 여부

		Node(int x, int y, int move, boolean wall) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.wall = wall;
		}
	}
}