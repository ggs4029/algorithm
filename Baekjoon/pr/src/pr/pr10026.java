// 백준 10026번
// 크기가 n * n인 그림이 입력으로 주어지면
// 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 문제.
// 각 칸의 색은 r, g, b 중 하나임.
// 방법---------------------
// 첫줄에 n이 주어짐.
// 둘째 줄부터는 n줄에 걸쳐 그림의 정보가 주어짐.
// bfs메소드랑 bfs사용해 구역 수 구하는 메소드 이렇게 두개 구현해 구역 수 출력.
// 적록색약 -> r = g 처럼 생각함.
// 모든 g를 r로 바꿔서 r, b에 대해서만 구하도록 만들기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr10026 {
	public static int n;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<n; j++)
				map[i][j] = input.charAt(j);
		}
		// bfs - 적록색약 아닌 경우
		int output1 = sum();
        // bfs - 적록색약인 경우
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j]=='G')									// g를 다
                	map[i][j] = 'R';								// r로 바꿈
            }
        }
        int output2 = sum();
        // 출력
        System.out.print(output1 + " " + output2);
	}

	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x, y});
		visited[x][y] = true;
		char color = map[x][y];
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(map[nx][ny]==color && !visited[nx][ny]) {	// 색상 같고 방문 안했으면
						visited[nx][ny] = true;
						q.offer(new int[]{nx, ny});
					}
				}
			}
		}
	}

	// 구역 수 구하는 메소드
	public static int sum() {
		visited = new boolean[n][n];
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
					sum++;
				}
			}
		}
		return sum;
	}
}