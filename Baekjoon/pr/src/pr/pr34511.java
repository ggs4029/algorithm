// 백준 2025 Centroid Cup C번
// 미노 퍼즐 조각을 맞추는 중임.
// 서로 맞닿아있는 선분들의 길이를 구하면서 퍼즐을 풀고자 함.
// 두 퍼즐 조각이 서로 맞닿아있는 선분들의 길이의 총합을 구해라.
// 방법---------------------
// 첫 줄에 보드 세로 크기 n, 가로 크기 m 입력 받음.
// 이후 n줄에 걸쳐 격자의 사태를 입력 받음.
// X = x퍼즐, Y = y퍼즐, . = 빈칸 임.
// 상하좌우 순회하면서 맞닿아 있는 부분들의 길이 총합 구해 출력.
// 범위 안에 두 점이 있고, 서로 다른 조각일 경우.
// 오답노트------------------
// 순회하면서 두번 구해진거 안나눳음 2로 나눠 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr34511 {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] puzzle = new char[n][m];
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<m; j++)
				puzzle[i][j] = input.charAt(j);
		}
		// 출력
		System.out.print(solve_puzzle(n, m, puzzle) / 2);
	}

	// 순회하며 선분길이 구하는 메소드
	public static int solve_puzzle(int n, int m, char[][] puzzle) {
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				char tmp = puzzle[i][j];
				if(tmp=='X' || tmp=='Y') {
					for(int k=0; k<4; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						if(ni>=0 && nj>=0 && ni<n && nj<m) {						// 범위 내이고
							char tmp2 = puzzle[ni][nj];
							if((tmp=='X' && tmp2=='Y') || (tmp=='Y' && tmp2=='X'))	// 서로 다른 조각이면
								sum++;												// 맞닿아있는 선분 길이 추가
						}
					}
				}
			}
		}
		return sum;
	}
}