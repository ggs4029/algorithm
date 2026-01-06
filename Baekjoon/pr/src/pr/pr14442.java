// 백준 14442번
// 크기 n * m인 행렬인 맵이 있음.
// 0은 이동할 수 있고 1은 벽임.
// (1, 1)에서 (n, m)까지 최단 경로로 이동하려함.
// 이동 중에 벽을 부수고 이동하는게 좀 더 경로가 짧아지면 k 개 까지 부수고 이동 가능.
// 맵이 주어지면 최단 거리를 구하는 문제.
// 방법---------------------
// 첫 줄에 n, m, k를 입력 받음.
// 다음 줄부터 n줄에 걸쳐 각 줄마다 m개의 숫자들을 입력 받는다.
// visited를 3차원으로 만들고 visited[x][y][z] -> z = 벽을 몇개 뚫었는지.
// Node클래스를 만들어 이동거리와 벽을 몇 개 부쉈는지 개수 체크.
// bfs 메소드에서 벽을 이미 k개까지 부쉈는지 체크하고 최단 거리를 출력.
// 오답노트------------------
// bfs 메소드 코드에서 조건문을 벽을 k개 미만으로 잡아야하는데 == 으로 잡아서 오류.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr14442 {
	public static int n, m, k;
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
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<m; j++)
				map[i][j] = input.charAt(j) - '0';
		}
		visited = new boolean[n][m][k+1];
		// 출력
		System.out.print(bfs());
	}

	// bfs 메소드
	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 1, 0));
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			if(tmp.x==n-1 && tmp.y==m-1)										// 끝 도착하면
				return tmp.move;												// 이동거리 리턴
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny] == 0) {										// 벽이 아니고
						if(!visited[nx][ny][tmp.wall]) {						// 방문 안했으면
							visited[nx][ny][tmp.wall] = true;					// 방문
							q.offer(new Node(nx, ny, tmp.move+1, tmp.wall));
						}
					}
					else if(map[nx][ny] == 1) {									// 벽이고
						if(tmp.wall < k) {										// 아직 벽 더 부술 수 있고
							if(!visited[nx][ny][tmp.wall+1]) {					// 방문 안했으면
								visited[nx][ny][tmp.wall+1] = true;				// 방문
								q.offer(new Node(nx, ny, tmp.move+1, tmp.wall+1));
							}
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
		int wall;																// 벽 몇 개 부쉈는지

		Node(int x, int y, int move, int wall) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.wall = wall;
		}
	}
}