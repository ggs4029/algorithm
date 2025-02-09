// 백준 11964번
// 베시가 주방에서 레몬과 오렌지를 발견했고 가능한 한 많이 먹으려고 할 때
// 베시의 최대 허기치가 t고 오렌지를 먹으면 a만큼 레몬을 먹으면 b만큼 허기치가 참.
// 추가적으로 물을 한 번 마실 수 있는데 이 때 물을 마시면 즉시 허기치가 절반으로 줄어듬. (소수점 이하 값은 버림 처리)
// 베시가 얻을 수 있는 최대 허기치를 구하는 문제. (t를 넘기지 않는 최댓값 구하는 문제)
// 방법---------------------
// 첫 줄에 두 정수 t, a, b가 주어짐.
// bfs 메소드 구헌하여
// 오렌지, 레몬, 물 먹는 경우 세가지로 나누어 탐색하고
// t를 넘기지 않는 최댓값 구해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pr11964 {
	public static boolean[][] visited;
	public static Queue<Bessie> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int t = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		visited = new boolean[t+1][2];
		q = new LinkedList<>();
		visited[0][0] = true;
		q.offer(new Bessie(0, false));
		// bfs + 출력
		System.out.print(bfs(t, a, b));
	}

	// bfs 메소드
	static int bfs(int t, int a, int b) {
		int output = 0;
		while(!q.isEmpty()) {
			Bessie tmp = q.poll();
			int fullness = tmp.fullness;
			boolean water = tmp.water;
			output = Math.max(output, fullness);
			int eat = fullness + a;							// 오렌지 먹기
			if(eat <= t) {
				if(water) {									// 물 먹은 후면
					if(!visited[eat][1]) {
						visited[eat][1] = true;
						q.offer(new Bessie(eat, water));
					}
				}
				else {										// 물 먹기 전이면
					if(!visited[eat][0]) {
						visited[eat][0] = true;
						q.offer(new Bessie(eat, water));
					}
				}
			}
			eat = fullness + b;								// 레몬 먹기
			if(eat <= t) {
				if(water) {
					if(!visited[eat][1]) {
						visited[eat][1] = true;
						q.offer(new Bessie(eat, water));
					}
				}
				else {
					if(!visited[eat][0]) {
						visited[eat][0] = true;
						q.offer(new Bessie(eat, water));
					}
				}
			}
			if(!water) {									// 물 안먹었으면
				eat = fullness / 2;							// 물 먹기
				if(!visited[eat][1]) {
					visited[eat][1] = true;
					q.offer(new Bessie(eat, true));
				}
			}
		}
		return output;
	}

	// 베시 클래스 - 베시의 현재 상태
	public static class Bessie {
		int fullness;							// 현재 허기치
		boolean water;							// 물을 마셨는지 여부

		Bessie(int fullness, boolean water) {
			this.fullness = fullness;
			this.water = water;
		}
	}
}