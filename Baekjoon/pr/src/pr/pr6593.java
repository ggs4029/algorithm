// 백준 7569번
// 상범 빌딩 탈출하기.
// 상범 빌딩을 탈출 할 수 있을지, 탈출 한다면 얼마나 걸리는지 출력하는 문제.
// 3차원 BFS를 이용한다.
// 방법---------------------
// 입력은 여러 개의 테스트 케이스로 이루어짐.
// 3차원 bfs로 문제 풀이.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr6593 {

	public static int l, r, c;
	public static char[][][] building;
	public static StringBuilder sb = new StringBuilder();
	public static int[] dx = {-1, 1, 0, 0, 0, 0};
	public static int[] dy = {0, 0, -1, 1, 0, 0};
	public static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		while(true) {
			String[] input = br.readLine().split(" ");
			l = Integer.parseInt(input[0]);
			r = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);
			if(l==0 && r==0 && c==0) {
				System.out.print(sb.toString());
				return;
			}
			int x = 0, y = 0, z = 0;
			building = new char[l][r][c];
			for(int i=0; i<l; i++) {
				for(int j=0; j<r; j++) {
					String input2 = br.readLine().trim();
					for(int k=0; k<c; k++) {
						building[i][j][k] = input2.charAt(k);
						if(building[i][j][k]=='S') {			// 시작점이면
							z = i;
							y = j;
							x = k;
							building[i][j][k] = '.';			// 비어있는 칸으로 변경
						}
					}
				}
				br.readLine();
			}
			// bfs
			bfs(x, y, z);
		}
	}

	// bfs 메소드
	public static void bfs(int x, int y, int z) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[l][r][c];
		q.add(new int[]{x, y, z, 0});
		visited[z][y][x] = true;
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int px = p[0];
			int py = p[1];
			int pz = p[2];
			int tmp = p[3];
			if(building[pz][py][px]=='E') {
				sb.append("Escaped in ").append(tmp).append(" minute(s).").append("\n");
				return;
			}
			for(int i=0; i<6; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				int nz = pz + dz[i];
				if(nx<0 || ny<0 || nz<0 || nx>=c || ny>=r || nz>=l)
					continue;
				if(visited[nz][ny][nx])
					continue;
				if(building[nz][ny][nx]=='.' || building[nz][ny][nx]=='E') {
					visited[nz][ny][nx] = true;
					q.add(new int[]{nx, ny, nz, tmp+1});
				}
			}
		}
		sb.append("Trapped!").append("\n");													// 탈출할 수 없는 경우
	}
}