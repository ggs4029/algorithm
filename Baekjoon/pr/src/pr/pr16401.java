// 백준 8986번
// 명절에 놀러오는 조카들에게 과자를 최대한 길게 줘야함.
// 나눠준 과자의 길이가 하나라도 다르면 조카들이 화를 냄.
// 따라서 반드시 모든 조카에게 같은 길이의 과자를 줘야함.
// m명의 조카가 있고 n개의 과자가 있을 때 조카 1명에게 주는 과자 길이의 최댓값 구하기.
// 막대 과자는 자를 수 있음.
// 방법---------------------
// 첫 줄에 조카 수 m과 과자의 수 n을 입력 받음.
// 다음 줄에 과자 n개의 길이들을 한 줄에 입력 받음.
// 이분 탐색으로 과자 길이에 따라
// 나눠줄 수 있는지 구하고 최대값을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr16401 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long[] snack = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			snack[i] = Long.parseLong(st.nextToken());
		// 정렬
		Arrays.sort(snack);
		// 이분 탐색
		long left = 1;													// 과자 최소 길이
		long right = snack[n - 1];
		while(left <= right) {
			long mid = (left + right) / 2;
			int tmp = 0;
			for(int i=0; i<n; i++){
				if(snack[i] >= mid)
					tmp += snack[i] / mid;
			}
			if(tmp >= m)												// 과자 나눠줄 수 있으면
				left = mid + 1;											// 왼쪽 포인터 오른쪽으로 옮기고 다시
			else														// 나눠줄 수 없으면
				right = mid - 1;										// 오른쪽 포인터 왼쪽으로 줄이고 다시
		}
		// 출력
		System.out.print(right);
	}
}