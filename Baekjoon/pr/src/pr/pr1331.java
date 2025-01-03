// 백준 1331번
// 나이트 투어 경로가 주어질 때, 이것이 올바른 것이면 Valid, 올바르지 않으면 Invalid를 출력하는 문제.
// 방법---------------------
// 36개 줄에 걸쳐 나이트가 방문한 순서가 주어진다.
// 방문 여부 기록할 2차원 배열, 입력 받은 이동 위치 기록할 2차원 배열
// 사용해서 조건에 맞게 이동 중인지 메소드로 체크하고 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1331 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] visited = new boolean[7][7];
		int[][] chess = new int[36][2];
		// 입력
		for(int i=0; i<36; i++) {
			String input = br.readLine();
			int x = input.charAt(0)-'A'+1;
			int y = Character.getNumericValue(input.charAt(1));
			if(x>=1 && x<=6 && y>=1 && y<=6 && !visited[x][y]) {		// 위치랑 방문 체크
				if(i!=0) {
					if(valid(chess[i-1][0], chess[i-1][1], x, y)) {		// 제대로 이동했는지 체크
						chess[i][0] = x;
						chess[i][1] = y;
						visited[x][y] = true;
					}
					else {
						System.out.print("Invalid");
						return;
					}
				}
				else {													// 첫번째 말
					chess[i][0] = x;
					chess[i][1] = y;
					visited[x][y] = true;
				}
			}
			else {
				System.out.print("Invalid");
				return;
			}
		}
		// 마지막 칸에서 처음으로 돌아올 수 있는지
		if(valid(chess[35][0], chess[35][1], chess[0][0], chess[0][1]))
			System.out.print("Valid");
		else
			System.out.print("Invalid");
	}

	// 검사 메소드
	public static boolean valid(int tmpX, int tmpY, int x, int y) {
		return (Math.abs(tmpX-x)==2 && Math.abs(tmpY-y)==1) ||
				(Math.abs(tmpX-x)==1 && Math.abs(tmpY-y)==2);
	}
}