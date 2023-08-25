// 백준 2563번
// 도화지에서 색종이가 붙은 영역의 넓이를 구하는 문제
// 방법--------------------------
// 도화지를 2차원배열로 표현하고 모두 0으로 초기화 한다
// 색종이의 수를 첫째 줄에 입력 받고
// 색종이의 시작 좌표를 색종이의 수만큼 입력 받는다.
// 입력 받은 좌표를 기준으로 색종이 크기만큼 그 좌표의 값을 1로 다 바꿔줌
// 그 후 색종이가 붙은 넓이를 값이 1인 좌표의 수를 세서 표현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 도화지의 크기는 100 * 100, 모든 칸을 0 으로 초기화
		int[][] paper = new int[100][100];
		for(int x=0; x<100; x++) {
			for(int y=0; y<100; y++)
				paper[x][y] = 0;
		}
		// 입력 받기
		int count = Integer.parseInt(br.readLine());
		for (int x=0; x<count; x++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]); // x좌표
			int b = Integer.parseInt(input[1]); // y좌표
			// 색종이 크기만큼 값을 1로 변경
			for(int y=0; y<10; y++) {
				for(int z=0; z<10; z++) {
					paper[a+y][b+z] = 1;
				}
			}
		}
		// 넓이 계산
		int sum = 0;
		for(int x=0; x<100; x++) {
			for(int y=0; y<100; y++) {
				if(paper[x][y] == 1) {
					sum++;
				}
			}
		}
		// 최종 출력
		System.out.print(sum);
	}
}