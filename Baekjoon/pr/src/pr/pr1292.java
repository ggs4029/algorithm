// 백준 1292번
// 쉽게 푸는 문제
// 문제에서 주어진 수열의 특정 구간의 합 구하기
// 방법----------------
// 구간의 시작 a와 구간의 끝 b를 입력 받고
// 수열을 먼저 b까지 쭉 구한 뒤,
// a부터 b까지 속하는 숫자의 합을 구하고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int a = Integer.parseInt(st.nextToken());	// 구간의 시작
		int b = Integer.parseInt(st.nextToken());	// 구간의 끝
		// b까지의 수열 구하기
		int[] seq = new int[b];
		int i = 0;
		for(int x=1; x<=b; x++) {
			for(int y=0; y<x; y++) {
				if(i == b)
					break;
				seq[i] = x;
				i++;
			}
		}
		// 합 구하기
		int sum = 0;
		for(int x=a; x<=b; x++) {
			sum+=seq[x-1];
		}
		// 출력
		System.out.print(sum);
	}
}