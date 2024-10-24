// 백준 14500번
// nxm 크기의 종이 위에 테트로미노를 하나 놓을 때,
// 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로하는 문제.
// 방법---------------------
// 첫 줄에 세로 크기 n, 가로 크기 m을 입력 받음.
// 다음 줄부터 n줄에 걸쳐 종이에 쓰여 있는 수들을 입력 받음.
// dfs를 4가 될 때까지 돌리고 결과를 구해 출력.
// T 모양은 dfs를 돌릴 수 없는 모양임 -> 예외처리 메소드 따로 구현.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr14500 {
	public static int n, m; 							// 세로 가로
	public static int sum = 0;
	public static int[][] paper;
	public static int[] dx = { 0, 0, -1, 1 }; 			// 좌우로 이동
	public static int[] dy = { -1, 1, 0, 0 }; 			// 상하로 이동

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		paper = new int[n][m];
		for (int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j=0; j<m; j++)
				paper[i][j] = Integer.parseInt(line[j]);
		}
		// dfs 이용한 최대값 구하기
		boolean[][] visit = new boolean[n][m]; 			// 방문 기록을 저장할 2차원 배열
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, paper[i][j], visit);
				visit[i][j] = false;
				exception(i, j);						// 예외 처리 (T 모양)
			}
		}
		// 출력
		System.out.println(sum);
	}

	// dfs
	public static void dfs(int y, int x, int cnt, int currentSum, boolean[][] visit) {
		if (cnt >= 4) {
			sum = Math.max(sum, currentSum);
			return;
		}
		// 상하좌우 탐색
		for (int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx]) {
				continue;
			}
			// 현재 칸 방문
			visit[ny][nx] = true;
			dfs(ny, nx, cnt + 1, currentSum + paper[ny][nx], visit);
			visit[ny][nx] = false;
		}
	}

	// T 모양 체크를 위한 메소드( T 모양은 dfs탐색 불가)
	public static void exception(int y, int x) {
		if (y < n - 2 && x < m - 1)
            sum = Math.max(sum, paper[y][x] + paper[y + 1][x] + paper[y + 2][x] + paper[y + 1][x + 1]);
        if (y < n - 2 && x > 0)
            sum = Math.max(sum, paper[y][x] + paper[y + 1][x] + paper[y + 2][x] + paper[y + 1][x - 1]);
        if (y < n - 1 && x < m - 2)
            sum = Math.max(sum, paper[y][x] + paper[y][x + 1] + paper[y][x + 2] + paper[y + 1][x + 1]);
        if (y > 0 && x < m - 2)
            sum = Math.max(sum, paper[y][x] + paper[y][x + 1] + paper[y][x + 2] + paper[y - 1][x + 1]);
	}
}