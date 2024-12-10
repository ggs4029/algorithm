// 백준 11689번
// 가장 처음에 N×N크기에 사탕을 채워 놓음. (사탕의 색은 모두 같지 않을 수도 있음)
// 사탕의 색이 다른 인접한 두 칸을 고르고, 고른 칸에 들어있는 사탕을 서로 교환.
// 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹음.
// 사탕이 채워진 상태가 주어졌을 때, 먹을 수 있는 사탕의 최대 개수를 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// 다음 n줄에 걸쳐 보드에 채워져 있는 사탕의 색상들이 주어짐.
// 이중 for문으로 배열을 순회하며 하나하나 교환해보고 최대값을 구함.
// 중복 사용되는 최대 사탕 개수를 구하는 과정은 메소드로 따로 구현.
// 계산 후 교환 전으로 배열을 다시 돌려놔야함.
// 최대 사탕 개수를 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr3085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		char[][] color = new char[n][n];
		for(int i=0; i<n; i++)
			color[i] = br.readLine().toCharArray();
		// 사탕 최대 개수 구하기
		int output = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 좌우 교환
				if(j<n-1) {
					char tmp = color[i][j];
					color[i][j] = color[i][j+1];
					color[i][j+1] = tmp;
					// 계산 후 재교환
					output = Math.max(output, maxCandy(color, n));
					tmp = color[i][j];
					color[i][j] = color[i][j+1];
					color[i][j+1] = tmp;
				}
				// 위아래 교환
				if(i<n-1) {
					char tmp = color[i][j];
					color[i][j] = color[i+1][j];
					color[i+1][j] = tmp;
					// 계산 후 재교환
					output = Math.max(output, maxCandy(color, n));
					tmp = color[i][j];
					color[i][j] = color[i+1][j];
					color[i+1][j] = tmp;
				}
			}
		}
		// 출력
		System.out.print(output);
	}

	private static int maxCandy(char[][] color, int n) {
		int tmp = 0;
		for(int i=0; i<n; i++) {
			int max1 = 1;												// 행
			int max2 = 1;												// 열
			// 행 세기
			for(int j=1; j<n; j++) {
				if(color[i][j-1]==color[i][j])
					max1++;
				else {													// 색 다르면
					tmp = Math.max(tmp, max1);							// 최대값 저장하고
					max1 = 1;											// 1부터 다시시작
				}
			}
			// 열 세기
			for(int j=1; j<n; j++) {
				if(color[j-1][i]==color[j][i])
					max2++;
				else {													// 색 다르면
					tmp = Math.max(tmp, max2);							// 최대값 저장하고
					max2 = 1;											// 1부터 다시시작
				}
			}
			tmp = Math.max(tmp, Math.max(max1, max2));
		}
		return tmp;
	}
}