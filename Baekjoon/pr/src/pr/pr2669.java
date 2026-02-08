// 백준 2669번
// 평면에 직사각형 네 개가 놓여 있음.
// 이 네개의 직사각형들은 서로 떨어져 있을 수도 있고, 겹쳐 있을 수도 있고,
// 하나가 다른 하나를 포함할 수도 있으며, 변이나 꼭짓점이 겹칠 수도 있음.
// 이 직사각형들이 차지하는 면적을 구하는 문제.
// 방법---------------------
// 첫 줄부터 네 줄에 걸쳐 각 줄에 직사각형의 왼쪽 아래와 오른쪽 위 x, y 좌표가 주어짐.
// 2차원 배열에 받은 좌표 안에 있는 사각형들 전부 1로 초기화.
// 1 개수만 세면 넓이 구할 수 있음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2669 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] grid = new int[101][101];
		for(int i=0; i<4; i++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 왼쪽 아래 꼭짓점
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			// 오른쪽 위 꼭짓점
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 좌표 저장
			for(int j=x1; j<x2; j++) {
				for(int k=y1; k<y2; k++)
					grid[j][k] = 1;
			}
		}
		// 면적 구하기
		int output = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++)
				output += grid[i][j];
		}
		// 출력
		System.out.print(output);
	}
}