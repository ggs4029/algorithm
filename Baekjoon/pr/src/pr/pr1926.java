// 백준 1926번
// n * m 크기의 사각형 모양의 도화지에 그림이 그려져 있음.
// 그림이라는 것은 도화지에서 1로 연결된 것을 말함. (대각선은 x)
// 도화지 안에 있는 그림의 개수와 그 중 가장 넓은 그림의 넓이를 출력하는 문제.
// 방법---------------------
// 첫 줄에 n과 m을 입력 받음.
// 다음 줄부터 n줄에 걸쳐 각 줄마다 m개의 숫자들을 입력 받음.
// 2차원 배열에 저장하고 dfs이용해 그림마다 넓이 구하고 저장.
// 그림의 개수와 제일 큰 그림 넓이 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class pr1926 {
	public static int n, m;
	public static int[][] paper;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		// 그림 개수 세고 넓이 저장하기
		ArrayList<Integer> picture = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(paper[i][j]==1 && !visited[i][j]) {
					sum = 0;
					dfs(i,j);
					picture.add(sum);
				}
			}
		}
		// 정렬
		Collections.sort(picture);
		// 출력
		sb.append(picture.size()).append("\n");
		if(picture.size() == 0)
			sb.append(0);
		else
			sb.append(picture.get(picture.size()-1));
		System.out.print(sb.toString().trim());
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;								// 방문
		sum++;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<m) {			// 범위 체크하고
				if(paper[nx][ny]==1 && !visited[nx][ny])	// 방문 안했으면
					dfs(nx, ny);
			}
		}
	}
}