// 백준 1149번
// RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
// 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
// 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때,
// 문제에서 주어진 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값 구하기.
// 방법---------------------
// 첫 줄에 집의 수 n이 주어짐.
// 둘째 줄부터 n개의 줄에 걸쳐 각 집을 빨, 초, 파로 칠하는 비용이 한 줄에 주어짐.
// 이차원 배열로 규칙을 만족하며 빨, 파, 초 칠하는 경우 세가지를
// for문을 돌며 누적합의 최솟값을 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n][3];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());				// 빨
			house[i][1] = Integer.parseInt(st.nextToken());				// 초
			house[i][2] = Integer.parseInt(st.nextToken());				// 파
		}
		// 최솟값 구하기
		for(int i=1; i<n; i++) {
			house[i][0] += Math.min(house[i-1][1], house[i-1][2]);		// 다른 색 지붕의 min값만 더해감
			house[i][1] += Math.min(house[i-1][0], house[i-1][2]);
			house[i][2] += Math.min(house[i-1][0], house[i-1][1]);
		}
		// 출력
		System.out.print(Math.min(house[n-1][0], Math.min(house[n-1][1], house[n-1][2])));
	}
}