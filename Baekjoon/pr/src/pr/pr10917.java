// 백준 10917번
// 당신이 꿈을 이루는 과정 중에 일어날 수 있는 수많은 상황들의 관계를 그래프로 나타내어 보겠다.
// 당신은 현재 1번 상황에 있다. 그리고 N번 상황은 당신이 이루고자 하는 유일한 꿈이다.
// 당신은 꿈을 이룰 수 있을까? 이룰 수 있다면 당신의 상황이 변화하는 횟수를 최소한으로 줄이면 몇 번 만에 꿈을 이룰 수 있을까?
// 당신이 선택할 수 있는 변화는 총 M개 있으며 x, y의 형태로 주어진다.
// 방법---------------------
// 첫 줄에 n, m 입력 받음.
// 다음줄부터 m줄에 걸쳐 x, y 들을 입력 받는다.
// bfs메소드 사용해 1번부터 출발.
// 꿈을 이룰 수 있는 최단 거리를 구해 값을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr10917 {

	public static ArrayList<ArrayList<Integer>> visited = new ArrayList<>();
	public static int[] dist;
	public static final int max = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i=0; i<=n; i++)
			visited.add(new ArrayList<>());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			visited.get(x).add(y);
		}
		dist = new int[n+1];
		Arrays.fill(dist, max);
		dist[1] = 0;									// 시작점
		// bfs 호출
		bfs(1);
		// 출력
		if(dist[n]==max)
			System.out.print(-1);
		else
			System.out.print(dist[n]);
	}

	// bfs 메소드
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i : visited.get(tmp)) {
				if(dist[i]==max) {						// 방문 전이면
					dist[i] = dist[tmp] + 1;
					q.offer(i);
				}
			}
		}
	}
}