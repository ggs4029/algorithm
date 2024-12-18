// 백준 25416번
// 5 x 5 크기의 보드가 주어지면
// 학생이 현재 위치 (r, c)에서 시작하여 1이 적혀 있는 칸에 도착하기 위한 최소 이동 횟수를 출력하는 문제
// 상하좌우 움직일 수 있음.
// 보드에 -1이 적혀 있는 칸으로는 이동할 수 없고 0, 1이 적혀 있는 칸으로는 이동할 수 있다.
// 방법---------------------
// 다섯 줄에 걸쳐 보드의 정보가 주어짐.
// 그 다음 줄에 학생의 현재 위치 r, c가 주어진다.
// bfs메소드에서 큐에 add할 때 거리를 함께 저장하도록 수정.
// 최단 거리를 출력. 1에 도달하지 못한 경우 -1을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr25416 {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][] board;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[5][5];
		visited = new boolean[5][5];
		for(int i=0; i<5; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			for(int j=0; j<5; j++)
				board[i][j] = Integer.parseInt(input[j]);
		}
		// 목표지점 찾기
		String[] input2 = br.readLine().split(" ");
		int r = Integer.parseInt(input2[0]);
		int c = Integer.parseInt(input2[1]);
		// bfs + 출력
		System.out.println(bfs(r, c));
	}

	// bfs
	public static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y, 0});
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x2 = tmp[0];
			int y2 = tmp[1];
			int output = tmp[2];
			if(board[x2][y2]==1)					// 1 도착하면 종료
				return output;
			for(int i=0; i<4; i++) {
				int nx = x2 + dx[i];
				int ny = y2 + dy[i];
				// 이미 방문한 곳 + -1인 구역 빼고 방문
				if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && board[nx][ny] != -1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[]{nx, ny, output+1});
				}
			}
		}
		return -1;									// 1 도착 못했으면 -1 리턴
	}
}