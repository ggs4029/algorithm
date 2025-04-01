// 백준 17129번
// 딱따구리가 어떤 음식에 제일 먼저 도착할지 구하는 문제.
// 2는 하나밖에 없음.
// 방법---------------------
// 첫 줄에 섬의 크기 n과 m이 주어짐.
// 이후 n행 m열에 걸쳐 012345로만 구성된 Aij들이 주어짐.
// bfs메소드 구현해서 탐색해 답을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr17129 {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int n, m;
	public static int[][] map;
	public static int[][] dist;
	private static int tmpX;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n][m];
		dist = new int[n][m];
		for(int i=0; i<n; i++) {
			String input2 = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = input2.charAt(j) - '0';
				dist[i][j] = -1;
			}
		}
		// 시작점 찾기
		int x = -1557;
		int y = -1557;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 2) {
					x = i;
					y = j;
					break;
				}
			}
			if(x != -1557)
				break;
		}
		// bfs
		int output = bfs(x, y);
		// 출력
		if(output == -1)
			System.out.print("NIE");
		else {
			System.out.println("TAK");
			System.out.print(output);
		}
	}

	// bfs메소드
	public static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		dist[x][y] = 0;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tmpX = tmp[0];
			int tmpY = tmp[1];
			if(map[tmpX][tmpY]==3 || map[tmpX][tmpY]==4 || map[tmpX][tmpY]==5)	// 음식이면
				return dist[tmpX][tmpY];										// 거리 리턴
			// 이동
			for(int i=0; i<4; i++) {
				int nx = tmpX + dx[i];
				int ny = tmpY + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny] != 1 && dist[nx][ny] == -1) {				// 장애물이 아니고 방문안했으면
						dist[nx][ny] = dist[tmpX][tmpY] + 1;					// 거리 +1 하고
						q.add(new int[]{nx, ny});								// 큐에 추가
					}
				}
			}
		}
		return -1;
	}
}