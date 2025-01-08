// 백준 1064번
// 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N에 있고, 동생은 점 K에 있다.
// 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
// 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
// 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 문제.
// 방법---------------------
// 첫 줄에 수빈이 위치 n과 동생 위치 k가 주어짐.
// 수빈이 위치, 시간 가지고 있는 클래스 만들어 사용.
// bfs탐색으로 최소 시간 구해 출력.
// 텔레포트는 0초 걸리기 때문에 +1, -1이동보다 위에 놓아야함에 주의.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr13549 {

	public static boolean[] visited;
	public static int n, k;
	public static int output = Integer.MAX_VALUE;
	public static int max = 100_000;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new boolean[max+1];
		bfs();
		// 출력
		System.out.print(output);
	}

	// 수빈이 위치, 시간 클래스
	public static class location {
		int x;
		int second;

		public location(int x, int second) {
			this.x = x;
			this.second = second;
		}
	}

	// bfs 메소드
	public static void bfs() {
		Queue<location> q = new LinkedList<>();
		q.offer(new location(n, 0));
		while(!q.isEmpty()) {
			location tmp = q.poll();
			visited[tmp.x] = true;
			if(tmp.x==k)
				output = Math.min(output, tmp.second);
			if(tmp.x*2<=max && visited[tmp.x*2]==false)
				q.offer(new location(tmp.x*2, tmp.second));
			if(tmp.x+1<=max && visited[tmp.x+1]==false)
				q.offer(new location(tmp.x+1, tmp.second+1));
			if(tmp.x-1>=0 && visited[tmp.x-1]==false)
				q.offer(new location(tmp.x-1, tmp.second+1));
		}
	}
}