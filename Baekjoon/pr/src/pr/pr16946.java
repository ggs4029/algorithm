// 백준 16946번
// 크기 n * m인 행렬인 맵이 있음.
// 0은 이동할 수 있고 1은 벽임.
// 각각의 벽에 대해 다음을 구할거임.
// 1. 벽을 부수고 이동할 수 있는 곳으로 변경
// 2. 그 위치에서 이동할 수 있는 칸의 개수를 세어보기
// 맵의 형태로 답을 출력하는 문제.
// 방법---------------------
// 첫 줄에 n, m를 입력 받음.
// 다음 줄부터 n줄에 걸쳐 각 줄마다 m개의 숫자들을 입력 받는다.
// bfs메소드 만들어 벽 부쉈다고 가정하고 주변 갈 수 있는곳 세서 출력.
// 오답노트------------------
// visited배열을 전역으로 둘게 아니라 매번 탐색하는 과정에서 초기화 하도록
// bfs메소드 안에서 초기화 하도록 수정.
// 오답노트2-----------------
// 모든 벽에 대해 bfs를 돌리기 -> 시간 초과
// 매번 bfs 하면 시간 초과니까  맨 처음에 한번 싹 전체 bfs 돌려서
// 벽이 아닌 덩어리들을 구하고, 그 각각의 덩어리들의 칸의 개수를 구하고 저장해놓기.
// 벽에 대해 상하좌우 확인하고 덩어리 있나 체크.
// 덩어리들 구별 -> bfs메소드를 따로 하나더 구현하고 그 안에서 해시셋을 사용해 저장
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr16946 {
	public static int n, m, k;
	public static int[][] map;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int[][] part;
	public static Map<Integer, Integer> map2 = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		part = new int[n][m];
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<m; j++)
				map[i][j] = input.charAt(j) - '0';
		}
		// bfs호출 - 덩어리 구하기
		int num = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0 && part[i][j]==0) {
					bfs(i, j, num);
					num++;
				}
			}
		}
		// 이동할 수 있는 칸의 개수 구하기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0)
					sb.append(0);
				else
					sb.append(count(i, j) % 10);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());
	}

	// bfs메소드 - 덩어리 정보 저장
	public static void bfs(int x, int y, int num) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x, y});
		part[x][y] = num;
		int sum = 1;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny]==0 && part[nx][ny]==0) {		// 다음 칸이 벽이 아니고 아직 포함 안했으면
						part[nx][ny] = num;
						q.offer(new int[]{nx, ny});
						sum++;
					}
				}
			}
		}
		map2.put(num, sum);
	}

	// 덩어리 크기 계산 메소드
	public static int count(int x, int y) {
		int sum = 1;
		HashSet<Integer> tmp = new HashSet<>();
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<m) {
				if(part[nx][ny] != 0)
					tmp.add(part[nx][ny]);
			}
		}
		for(int i : tmp)
			sum += map2.get(i);
		return sum;
	}
}