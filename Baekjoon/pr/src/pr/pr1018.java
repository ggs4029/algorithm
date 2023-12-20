// 백준 1018번
// 체스판 다시 칠하기
// 아무렇게나 색칠되어있는 mn크기의 판을 최소로 다시 칠하는 경우 구하기
// 방법-----------------
// n과 m을 입력 받고 그 크기만큼 배열을 만든다.
// 입력 받은 보드의 상태를 배열에 0,1로 입력하고
// for문을 돌려 모든 경우를 탐색
// 첫번째 칸을 다른색으로 칠하고 시작하는 경우가 원래의 경우보다
// 더 작게 나오는 경우를 주의해서 최솟값을 찾아 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		// 배열 생성과 입력
		int[][] chess = new int[n][m];
		int answer = 64;						// 나올수있는 최댓값 64
		for(int x=0; x<n; x++) {
			String input2 = br.readLine();
			for(int y=0; y<m; y++) {
				if(input2.charAt(y) == 'B') {	// Black인 경우
					chess[x][y] = 0;
				}
				else {							// White인 경우
					chess[x][y] = 1;
				}
			}
		}

		// 탐색
		for(int x=0; x<n-7; x++) {
			for(int y=0; y<m-7; y++) {
				int count = 0;						// 다시 칠해야하는 칸 수
				int color = chess[x][y];			// 첫번째 정사각형의 색

				for(int i=x; i<x+8; i++) {
					for(int j=y; j<y+8; j++) {
						if(chess[i][j] != color) {	// 다른색이면 count+1
							++count;
						}
						// 다음 칸이 반대색이 되도록 color값 바꾸기
						if(color==1) {
							color = 0;
						}
						else {
							color = 1;
						}
					}
					// 다음 줄의 첫번째 칸의 색은
					// 반대색이 되므로 color값 바꾸기
					if(color==1) {
						color = 0;
					}
					else {
						color = 1;
					}
				}
				// 첫번째 칸을 반대색으로 칠하고 시작하는 경우가
				// 원래의 count보다 작으면 count값 바꾸기
				if(count>64-count) {
					count = 64-count;
				}
				// 원래의 answer이랑 비교
				if(answer>count) {
					answer = count;
				}
			}
		}

		// 출력
		System.out.print(answer);
	}
}