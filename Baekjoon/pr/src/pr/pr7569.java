// 백준 7569번
// 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어지면
// 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 문제.
// 백준 7576번이 1차원이면 이 문제는 h가 더해진 2차원.
// 방법---------------------
// 첫줄에 상자의 크기와 높이를 나타내는 세 정수 m, n, h가 주어짐.
// 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보들이 n*h줄에 걸쳐 주어짐.
// 익은 토마토를 큐에 추가해가고 익지 않은 토마토는 tmp에 +1.
// bfs를 돌며 인접한 여섯방향의 토마토들을 탐색해감.
// 익지 않은 토마토가 남아있는지 확인하고 -1, 0 이나 양의 정수를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr7569 {

	public static int m, n, h;
	public static int[][][] list;
	public static boolean[][] visited;
	public static Queue<int[]> q = new LinkedList<>();
	public static int[] dx = {-1, 1, 0, 0, 0, 0};
	public static int[] dy = {0, 0, -1, 1, 0, 0};
	public static int[] dz = {0, 0, 0, 0, -1, 1};
	public static int tmp = 0;												// 안 익은 토마토의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		m = Integer.parseInt(input[0]);
		n = Integer.parseInt(input[1]);
		h = Integer.parseInt(input[2]);
		list = new int[h][n][m];
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				String[] input2 = br.readLine().split(" ");
				for(int j=0; j<m; j++) {
					list[k][i][j] = Integer.parseInt(input2[j]);
					if(list[k][i][j]==1)										// 익은 토마토면
						q.add(new int[]{k, i, j, 0});								// 큐에 추가
					else if(list[k][i][j]==0)									// 안 익었으면
						tmp++;
				}
			}
		}
		// bfs + 출력
		System.out.print(bfs());
	}

	// bfs
	public static int bfs() {
		int output = 0;
		while(!q.isEmpty()) {
			int[] tmp2 = q.poll();
			int z = tmp2[0]; int x = tmp2[1]; int y = tmp2[2];					// 토마토 위치
			int day = tmp2[3];													// 익기까지 걸린 시간
			for(int j=0; j<6; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				int nz = z + dz[j];
				if(nx>=0 && ny>=0 && nz>=0
						&& nx<n && ny<m && nz<h
							&& list[nz][nx][ny] == 0) {							// 안 익은 토마토면
					list[nz][nx][ny] = 1;										// 익었다고 바꿔주고
					tmp--;														// 안 익은 토마토 개수 - 1
					q.offer(new int[]{nz, nx, ny, day+1});							// 큐에 추가해 다음날 익도록 함
					output = day+1;												// 날짜 + 1
				}
			}
		}
		if(tmp>0)																// 안 익은 토마토가 남은 경우
			return -1;
		else
			return output;
	}
}