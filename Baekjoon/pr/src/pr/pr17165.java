// 백준 17165번
// 주어진 입력에 대해서 가장 약점이 적은 학생을 고수로 출력 + 그 학생의 약점을 출력하는 문제.
// 고수 = 승리 경로의 길이가 최소인 학생, 즉 여러명일수도 있다.
// 방법---------------------
// 첫 줄에 학생 수 n이 입력으로 주어짐.
// n줄에 걸쳐 학생들의 승패 정보가 주어진다.
// 다 이긴 경우 -> 약점 = 1
// 한번이라도 진 경우 -> 약점 = 2 (=9000인 경우는 없다)
// 제일 많이 승리한 애 찾아서 bfs 돌리고 제일 큰 최단거리 + 제일 많이 승리한 애 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class pr17165 {
	public static int n;											// 학생 수
	public static String[] input;									// 입력용
	public static int[] visited;									// bfs 탐색용
	public static int[] result;										// 이겼는지 결과 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		n = Integer.parseInt(br.readLine());
		input = new String[n];
		visited = new int[n];
		result = new int[n];
		for(int i=0; i<n; i++)
			input[i] = br.readLine();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(input[i].charAt(j)=='W')							// 이겼으면
					result[i]++;
			}
		}
		// 제일 많이 이긴애 찾기
		int output = 0;												// 승리 횟수 저장할 변수
		int gosu = 0;												// gosu
		for(int i=0; i<n; i++) {
			if(result[i]>output) {
				output = result[i];
				gosu = i;
			}
		}
		// bfs + Max최단거리 구하기
		bfs(n, gosu);
		int max = Integer.MIN_VALUE;
		for(int i=0; i<visited.length; i++) {
			if(visited[i] > max)
				max = visited[i];
		}
		sb.append((max - 1)).append(" ").append(gosu + 1).append("\n");
		// 출력
		System.out.print(sb.toString());
	}

	// bfs
	public static void bfs(int num, int start) {
		Arrays.fill(visited, -1);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = 1;
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			for(int i=0; i<num; i++) {
				// 이미 방문했거나, i가 tmp에게 이겼으면 건너뜀
				if(visited[i] != -1 || input[tmp].charAt(i) != 'W')
					continue;
				visited[i] = visited[tmp] + 1;
				queue.add(i);
			}
		}
	}
}