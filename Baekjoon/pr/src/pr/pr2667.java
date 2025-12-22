// 백준 2667번
// 정사각형 모양의 지도에서 1은 집 0은 집이 없는 곳임.
// 연결된 집의 모임을 단지라고 하고 단지에 번호를 붙이려 함.
// 지도가 주어지면 단지수를 출력하고 각 단지에 속하는 집 수를 오름차순으로 정렬해 출력하는 문제.
// 방법---------------------
// 첫 줄에 n 입력 받음.
// 다음 줄부터 n줄에 걸쳐 각 줄마다 n개의 숫자들을 입력 받음.
// 2차원 배열에 저장하고 dfs이용해 단지마다 집 수 구하고 저장.
// 단지 수와 단지에 속하는 집 수 오름차순으로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class pr2667 {
	public static int n;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<n; j++)
				map[i][j] = input.charAt(j) - '0';
		}
		// 단지 수랑 단지 내 집 수 세기
		ArrayList<Integer> complex = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					sum = 0;
					dfs(i,j);
					complex.add(sum);
				}
			}
		}
		// 정렬
		Collections.sort(complex);
		// 출력
		sb.append(complex.size()).append("\n");
		for(int i : complex)
			sb.append(i).append("\n");
		System.out.print(sb.toString().trim());
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;								// 방문
		sum++;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n) {			// 범위 체크하고
				if(map[nx][ny]==1 && !visited[nx][ny])		// 방문 안했으면
					dfs(nx, ny);
			}
		}
	}
}