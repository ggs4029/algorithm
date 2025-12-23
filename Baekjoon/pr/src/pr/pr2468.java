// 백준 2468번
// 정사각형 모양의 n * n 지도에서 많은 비가 내릴 예정임.
// 지역의 높이 정보를 먼저 파악하고, 많은 비가 내렸을 때
// 물에 잠기지 않는 안전한 영역이 최대 몇 개가 만들어 지는 지를 조사하려함.
// 어떤 지역의 높이 정보가 주어지면, 생기는 안전 지대의 최대 개수를 구하기.
// 방법---------------------
// 첫 줄에 n 입력 받음.
// 다음 줄부터 n줄에 걸쳐 각 줄마다 n개의 숫자들을 입력 받음.
// 2차원 배열에 저장하고 강수량을 0부터 그 지역에서 제일 높은 높이까지 1씩 늘려가며
// dfs 돌려 안전 지대 개수 체크하고 최댓값 갱신해 마지막에 최댓값 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2468 {
	public static int n;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int max = 0;													// 이 지역의 최고 높이
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > max)
					max = map[i][j];
			}
		}
		// 안전 지대 최대 개수 구하기
		int output = 0;
		for(int i=0; i<=max; i++) {
			visited = new boolean[n][n];
			int safe = 0;												// 구한 언전 지대 개수
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(map[j][k]>i && !visited[j][k]) {
						dfs(i, j, k);
						safe++;
					}
				}
			}
			output = Math.max(output, safe);
		}
		// 출력
		System.out.print(output);
	}

	// dfs 메소드
	public static void dfs(int h, int x, int y) {
		visited[x][y] = true;								// 방문
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n) {			// 범위 체크하고
				if(map[nx][ny]>h && !visited[nx][ny])		// 안전 지대인데 방문 안했으면
					dfs(h, nx, ny);
			}
		}
	}
}