// 백준 1920번
// n개의 정수들 안에 x라는 정수가 존재하는지 알아내는 문제
// 방법---------------------
// 첫째 줄에 n을 입력 받고 다음 줄에 n개의 정수들을 입력 받는다
// 셋째 줄에 m을 입력 받고 다음 줄에 m개의 정수들을 입력 받는다
// m개의 정수들에 대한 대답을 존재하면 1 아니면 0 으로 출력한다.
// 주의! - 시간 초과에 주의 - 이분 탐색 이용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		long[] inputN = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			inputN[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		long[] inputM = new long[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			inputM[i] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(inputN);
		// 존재 여부 판정 후 출력
		for(int i=0; i<m; i++) {
			if(Arrays.binarySearch(inputN, inputM[i])>=0)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}