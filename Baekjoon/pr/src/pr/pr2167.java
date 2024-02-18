// 백준 2167번
// 2차원 배열의 합
// 2차원 배열의 특정 범위의 합 구하기
// 방법-------------------
// 첫줄에 2차원 배열의 크기 n, m을 입력 받음.
// n개 줄에 걸쳐 m개의 정수로 배열을 입력 받음.
// 그 다음 줄에 몇번 특정 범위의 합을 구할건지 k를 입력 받고
// k줄에 걸쳐 (i,j), (x,y)를 입력 받는다.
// 주어진 범위의 sum값을 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2167 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] input = new int[n][m];
		for(int x=0; x<n; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y=0; y<m; y++) {
				input[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		int k = Integer.parseInt(br.readLine());
		for(int a=0; a<k; a++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 합 구하기
			int sum = 0;
			for(int b=i-1; b<x; b++) {
				for(int c=j-1; c<y; c++) {
					sum += input[b][c];
				}
			}
			// 출력
			System.out.println(sum);
		}
	}
}