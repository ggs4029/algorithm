// 백준 1012번
// 2차원 배열에서 배추들이 몇 군데에 퍼져있는지 조사하고 출력하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어지고
// 그 다음줄부터 테스트 케이스에 대해 첫 줄에 배추밭의 가로 길이 m,
// 세로 길이 n, 배추가 심어져 있는 위치의 개수 k가 주어짐.
// 두번째 줄부터 k줄에 걸쳐 배추의 위치가 주어짐.
// 2차원 배열 dfs 탐색후 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1012 {

	public static int[][] vegetable;
	public static boolean[][] visited;
	public static int m, n;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			m = Integer.parseInt(input[0]);
			n = Integer.parseInt(input[1]);
			vegetable = new int[m][n];
			visited = new boolean[m][n];
			int k = Integer.parseInt(input[2]);
			for(int j=0; j<k; j++) {
				String[] input2 = br.readLine().split(" ");
				vegetable[Integer.parseInt(input2[0])][Integer.parseInt(input2[1])] = 1;	// 배추 심어주고
			}
			// dfs 호출
			int output = 0;
			for(int j=0; j<m; j++) {
				for(int l=0; l<n; l++) {
					if(vegetable[j][l]==1 && !visited[j][l]) {
						dfs(j, l);
						output++;
					}
				}
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}

	// dfs
	public static void dfs(int x, int y) {
		// 방문
		visited[x][y] = true;
		// 연결된 배추 탐색
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for(int i=0; i<4; i++) {
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			if(nx>=0 && ny>=0 && nx<m && ny<n && vegetable[nx][ny] == 1 && !visited[nx][ny])
				dfs(nx, ny);
		}
	}

}