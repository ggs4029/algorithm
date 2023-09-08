// 백준 25305번
// 점수 커트라인을 구하는 문제
// 방법--------------
// 첫째 줄에 응시자 수 N과 상을 받는 사람의 수 k를 입력 받고
// 둘째 줄에 N개의 점수를 입력 받는다.
// 정렬을 이용해 커트라인을 구하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr25305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		String[] input2 = br.readLine().split(" ");
		int[] score = new int[n];
		for (int x = 0; x < score.length; x++) {
			score[x] = Integer.parseInt(input2[x]);
		}
		// 정렬
		Arrays.sort(score);
		// 최종 출력
		System.out.print(score[score.length - k]);
	}
}
