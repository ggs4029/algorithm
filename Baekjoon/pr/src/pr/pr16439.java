// 백준 16439번
// n명이서 치킨 시킬건데 시키는 치킨의 종류가 많아질수록
// 치킨을 튀기는 데에 걸리는 시간도 길어지기 때문에 최대 세 가지 종류의 치킨만 시키고자 합니다.
// 진수를 도와 가능한 만족도의 합의 최댓값을 구해주세요.
// 방법---------------------
// 첫 줄에 정수 n 입력 받음.
// 둘째 줄부터 사람들의 선호도를 한줄에 입력 받음.
// for문중첩해 구현 + 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr16439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] input2 = br.readLine().split(" ");
			for (int j = 0; j < m; j++)
				tmp[i][j] = Integer.parseInt(input2[j]);
		}
		// 만족도의 합의 최댓값 구하기
		int output = 0;
		for (int i = 0; i < m - 2; i++) {
			for (int j = i + 1; j < m - 1; j++) {
				for (int k = j + 1; k < m; k++) {
					int tmp2 = 0;
					for (int l = 0; l < n; l++) {
						int max = Math.max(tmp[l][i],
								Math.max(tmp[l][j],
										tmp[l][k]));
						tmp2 += max;
					}
					output = Math.max(output, tmp2);
				}
			}
		}
		// 출력
		System.out.print(output);
	}
}