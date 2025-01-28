// 백준 28357번
// 음이 아닌 정수 x를 정한 뒤 최종 점수가 x점을 넘는 학생들에게 점수가 높은 만큼 많은 사탕을 줄 것이다.
// 즉, t점을 받으면 t - x개의 사탕을 받게됨.
// 학생들에게 최대한 많은 사탕을 나누어주고 싶기 때문에 기준 점수 x를 가능한 한 낮게 정하려 한다.
// 하지만, 사탕을 k개까지만 살 수 있기 때문에 사탕의 총 개수가 k개를 넘으면 안 된다.
// 수업을 n명이 수강했을 때 가능한 x의 최솟값 구하기.
// 방법---------------------
// 첫째 줄에 n과 k가 주어짐.
// 둘째 줄에 n개의 정수들이 주어진다.
// 이분 탐색하며 최소 x 구하기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr28357 {
	public static long k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());
		long[] score = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			score[i] = Long.parseLong(st.nextToken());
		// 출력
		long tmp = Long.MIN_VALUE;
		for(int i=0; i<score.length; i++) {
			if(score[i]>tmp)
				tmp = score[i];
		}
		System.out.print(bs(score, 0, tmp));
	}

	// 이분 탐색
	public static long bs(long[] arr, long low, long high) {
		while(low<high) {
			long mid = (low + high) / 2;
			long tmp = 0;							// x가 mid일 때 나눠줄 사탕 개수 저장할 변수
			for(int i=0; i<arr.length; i++) {
	            if(arr[i]>mid)
	                tmp += arr[i] - mid;
	        }
			if(tmp>k) 								// 사탕이 부족하면
				low = mid + 1;						// 점수 올리기
			else
				high = mid;
		}
		return low;
	}
}