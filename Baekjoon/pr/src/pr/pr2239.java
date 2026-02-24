// 백준 2239번
// 하다만 스도쿠 퍼즐이 주어지면 마저 끝내는 문제.
// 답이 여러 개 라면 사전식으로 앞서는 것 출력.
// 방법---------------------
// 9개 줄에 걸쳐 매 줄마다 9개의 숫자가 입력됨.
// 아직 숫자가 채워지지않은 칸은 0 으로 표시.
// 반복문 돌면서 빈칸 채워나가기.
// 빈 칸에 1~9 넣어보면서 그걸 넣었을 때
// 가로, 세로, 3*3사각형 다 조건에 맞는지 확인하고
// 맞으면 수 넣고 다음 빈칸 다시 검사.
// 이런식으로 채우고 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class pr2239 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int[][] sudoku = new int[9][9];
		ArrayList<int[]> nums = new ArrayList<>();
		for(int i=0; i<9; i++) {
			String input = br.readLine();
			for(int j=0; j<9; j++) {
				sudoku[i][j] = input.charAt(j) - '0';
				if(sudoku[i][j] == 0)
					nums.add(new int[]{i, j});
			}
		}
		// 스도쿠 채우기
		int size = nums.size();
		int tmp = 0;
		while(tmp < size) {
			int[] num = nums.get(tmp);
			int x = num[0];
			int y = num[1];
			boolean ok = false;
			// 현재 칸에 들어있는 값 다음부터 9까지 시도
			for(int i=sudoku[x][y]+1; i<=9; i++) {
				// 가로, 세로 검사
				boolean ok1 = true;
				for(int j=0; j<9; j++) {
					if(sudoku[x][j]==i || sudoku[j][y]==i) {	// 가로줄과 세로줄에 중복 숫자 있는지
						ok1 = false;
						break;
					}
				}
				if(!ok1)
					continue;
				// 3 * 3 사각형 검사
				boolean ok2 = true;
				for(int j=(x/3)*3; j<(x/3)*3+3; j++) {
					for(int k=(y/3)*3; k<(y/3)*3+3; k++) {
						if(sudoku[j][k] == i) {					// 칸 안에 중복 숫자 있는지
							ok2 = false;
							break;
						}
					}
					if(!ok2)
						break;
				}
				if(ok1 && ok2) {
					sudoku[x][y] = i;
					ok = true;
					break;
				}
			}
			if(ok)												// 숫자 찾았으면
				tmp++;
			else {												// 못 찾았으면
				sudoku[x][y] = 0;
				tmp--;
			}
		}
		// 출력
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++)
				sb.append(sudoku[i][j]);
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());
	}
}