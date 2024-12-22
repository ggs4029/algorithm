// 백준 10157번
// 공연장의 크기를 나타내는 자연수 C와 R이 주어져 있을 때,
// 대기 순서가 K인 관객에게 배정될 좌석 번호 (x,y)를 찾는 프로그램을 작성해야함.
// 좌석 배정 방법은 문제에 나와 있음.
// 방법---------------------
// 첫 줄에 공연장의 크기를 나타내는 정수 c, r이 주어짐.
// 그 다음 줄에는 어떤 관객의 대기 번호 k가 주어짐.
// while문을 돌며 시계 방향으로 좌석을 배치해가며 k의 위치를 구한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int c = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		int k = Integer.parseInt(br.readLine());
		int[][] seat = new int[r][c];
		// k의 좌석 번호 찾기
		if(k>r*c) {
			System.out.print(0);
			return;
		}
		int[] dx = {-1, 0, 1, 0};										// 맨 왼쪽 아래부터 시계방향으로 이동할 때 x좌표 방향
		int[] dy = {0, 1, 0, -1};										// y좌표 방향
		int d = 0;
		int x = r-1;
		int y = 0;
		int tmp = 1;													// 배정된 좌석 수
		seat[x][y] = tmp;												// 시작점 배정
		while(tmp<k) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx>=0 && ny>=0 && nx<r && ny<c && seat[nx][ny]==0) {	// 공연장 안이고 배정 전이면
				seat[x][y] = ++tmp;										// 배정
				x = nx;
				y = ny;
			}
			else														// 공연장 밖이거나 이미 배정되어 있으면
				d = (d + 1) % 4;										// 방향 틀기
		}
		// 출력
		System.out.print(y+1 + " ");
		System.out.print(r - x);
	}
}