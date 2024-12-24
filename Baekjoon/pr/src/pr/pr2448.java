// 백준 2448번
// 별 찍기 -11
// 예제 보고 재귀로 별 찍기
// 방법---------------------
// 첫 줄에 n이 주어진다. (n은 항상 3 * 2^k인 수임)
// 재귀 메소드 구현해서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2448 {

	public static char[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 별 그리기
		star = new char[n][2*n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<2*n; j++)
				star[i][j] = ' ';						// 공백 먼저 채우고
		}
		draw(0, n-1, n);								// 별 그리기
		// 출력
		for(int i=0; i<n; i++) {
			for(int j=0; j<2*n; j++)
				sb.append(star[i][j]);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	// 별 그리기 메소드
	public static void draw(int x, int y, int tmp) {
		// 기본적인 별 그리기
		if(tmp==3) {
			star[x][y] = '*';							// 1층
			star[x+1][y-1] = '*';						// 2층
			star[x+1][y+1] = '*';
			star[x+2][y-2] = '*';						// 3층
			star[x+2][y-1] = '*';
			star[x+2][y] = '*';
			star[x+2][y+1] = '*';
			star[x+2][y+2] = '*';
			return;
		}
		// 재귀
		int tmp2 = tmp / 2;
		draw(x + tmp2, y - tmp2, tmp2);					// 왼
        draw(x + tmp2, y + tmp2, tmp2);					// 오
        draw(x, y, tmp2);								// 위
	}
}