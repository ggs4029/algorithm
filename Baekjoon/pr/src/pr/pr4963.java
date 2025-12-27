// 백준 4963번
// 사각형 모양의 지도에서 1은 땅 0은 바다임.
// 어떤 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형임.
// 지도가 주어지면 섬의 개수를 세서 출력하는 문제.
// 방법---------------------
// 입력은 여러 개의 테스트 케이스를 계속 받을 거임.
// 각 테스트 케이스의 입력 첫 줄은 지도의 너비와 높이 w, h를 입력 받음.
// 다음 줄부터 h줄에 걸쳐 지도를 입력 받음.
// 대각선도 걸어갈 수 있으니까 dx, dy에 대각선 이동 늘려주고
// dfs로 섬 개수 세서 출력.
// 오답노트------------------
// 지도를 정사각형으로 입력 받은게 아니라 너비가 w 높이가 h이므로
// dfs 메소드에서 범위체크 할 때 h랑 w를 기준으로 체크해야함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr4963 {
	public static int n, w, h;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
	public static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0)
				break;
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			// 섬 개수 세기
			int output = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						output++;
						dfs(i,j);
					}
				}
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// dfs 메소드
	public static void dfs(int x, int y) {
		visited[x][y] = true;								// 방문
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<h && ny>=0 && ny<w) {			// 범위 체크하고
				if(map[nx][ny]==1 && !visited[nx][ny])		// 방문 안했으면
					dfs(nx, ny);
			}
		}
	}
}