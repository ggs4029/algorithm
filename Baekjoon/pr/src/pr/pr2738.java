// 백준 2738번
// 두 행렬을 입력 받아
// 두 행렬을 덧셈하는 문제
// 방법---------------
// 행렬의 크기 N과 M을 입력 받고
// N개의 줄로 행렬 A를 입력 받고
// 그 다음 N개의 줄로 행렬 B를 입력 받는다.
// 행렬A와 행렬B를 더한 행렬을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2738 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N, M 입력 받기, 행렬 A, B 선언
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int[][] arrA = new int[n][m];
		int[][] arrB = new int[n][m];
		// 행렬 A 입력 받기
		for (int x = 0; x < n; x++) {
			String input[] = br.readLine().split(" ");
			for (int y = 0; y < m; y++) {
				arrA[x][y] = Integer.parseInt(input[y]);
			}
		}
		// 행렬 B 입력 받기
		for (int x = 0; x < n; x++) {
			String input[] = br.readLine().split(" ");
			for (int y = 0; y < m; y++) {
				arrB[x][y] = Integer.parseInt(input[y]);
			}
		}
		// 행렬을 더한 뒤 출력
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				System.out.print(arrA[x][y]+arrB[x][y]+" ");
			}
			System.out.println();
		}
	}
}