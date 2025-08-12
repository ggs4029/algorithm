// 백준 2740번
// 두 행렬 a, b를 곱하는 문제
// 방법---------------------
// 첫 줄에 행렬 a의 크기 n과 m을 입력 받음.
// 두번째 줄에 행렬 b의 크기 m과 k가 주어짐.
// 입력 받은 행렬 a, b를 곱하여 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2740 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] a = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++)
				a[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] b = new int[m][k];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<k; j++)
				b[i][j] = Integer.parseInt(st.nextToken());
		}
		// 행렬 계산
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				int sum = 0;
				for(int l=0; l<m; l++) {
					sum += a[i][l] * b[l][j];
				}
				sb.append(sum+ " ");
			}
			sb.append('\n');
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}