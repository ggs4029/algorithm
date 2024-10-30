// 백준 1697번
// 수빈이와 동생의 위치가 주어지면, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간을 구하는 문제.
// 수빈이가 걷는 경우 : 1초 후에 X-1 또는 X+1로 이동
// 수빈이가 순간이동 하는 경우 : 1초 후에 2*X의 위치로 이동
// 방법---------------------
// 첫 줄에 수빈이 위치 n, 동생 위치 k를 입력 받음.
// 최단 시간 경로 찾기 - bfs
// bfs 돌려 시간 값 출력.
// 주의! - bfs 내에서 현재 레벨의 모든 노드를 돌아야함(for문)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class pr1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		// bfs호출과 출력
		System.out.print(bfs(n, k));
	}

	// bfs
	public static int bfs(int s, int e) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];					// 0~10만까지 숨기 가능
		// 방문
		q.offer(s);
		visited[s] = true;
		// 연결된 정점 탐색
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();										// 현재 레벨의 노드 개수
			for(int i=0; i<size; i++) {									// 지금 레벨의 모든 노드 탐색
				int tmp = q.poll();
				if(tmp==e)												// 동생한테 도착하면
					return time;										// 끝
				// 다음 행동 정하기
				int[] next = {tmp-1, tmp+1, tmp*2};
				for(int j : next) {
					if(j>=0 && j<=100000 && !visited[j] ) {				// 검사 순서 주의 j>=0인지 먼저 검사해야함(visited[j]때문)
						visited[j] = true;
						q.offer(j);
					}
				}
			}
			time++;
		}
		return -2513;
	}
}