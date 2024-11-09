// 백준 7576번
// 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어지면
// 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 문제.
// 방법---------------------
// 첫줄에 상자의 크기를 나타내는 두 정수 m, n이 주어짐.
// 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보들이 n줄에 걸쳐 주어짐.
// 익은 토마토를 큐에 추가해가고 익지 않은 토마토는 tmp에 +1.
// bfs를 돌며 인접한 네방향의 토마토들을 탐색해감.
// 익지 않은 토마토가 남아있는지 확인하고 -1, 0 이나 양의 정수를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr7576 {

	public static int m, n;
	public static int[][] list;
	public static boolean[][] visited;
	public static Queue<int[]> q = new LinkedList<>();
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int tmp = 0;												// 안 익은 토마토의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		m = Integer.parseInt(input[0]);
		n = Integer.parseInt(input[1]);
		list = new int[n][m];
		for(int i=0; i<n; i++) {
			String[] input2 = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				list[i][j] = Integer.parseInt(input2[j]);
				if(list[i][j]==1)											// 익은 토마토면
					q.add(new int[]{i, j, 0});								// 큐에 추가
				else if(list[i][j]==0)										// 안 익었으면
					tmp++;
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
			int x = tmp2[0]; int y = tmp2[1];								// 토마토 위치
			int z = tmp2[2];												// 익기까지 걸린 시간
			for(int j=0; j<4; j++) {
				int nx = x+ dx[j];
				int ny = y+ dy[j];
				if(nx>=0 && ny>=0 && nx<n && ny<m && list[nx][ny] == 0) {	// 안 익은 토마토면
					list[nx][ny] = 1;										// 익었다고 바꿔주고
					tmp--;												// 안 익은 토마토 개수 - 1
					q.offer(new int[]{nx, ny, z+1});						// 큐에 추가해 다음날 익도록 함
					output = z+1;											// 날짜 + 1
				}
			}
		}
		if(tmp>0)														// 안 익은 토마토가 남은 경우
			return -1;
		else
			return output;
	}
}