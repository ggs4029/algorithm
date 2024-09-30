// 백준 1654번
// 랜선 자르기 문제
// 랜선 n개를 만들수 있는 최대 길이를 구해 출력하는 문제
// 방법---------------------
// 첫 줄에 이미 가지고 있는 랜선 개수 k, 그리고 필요한 랜선 개수 n을 입력 받는다.
// 다음 줄부터 k줄에 걸쳐 이미 가지고 있는 랜선들의 길이를 한줄씩 입력 받는다.
// 이분 탐색 이용하여 제일 작은 랜선길이와 제일 큰 랜선길이의 중간 길이부터 탐색.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] len = new int[k];
		for(int i=0; i<k; i++) {
			len[i] = Integer.parseInt(br.readLine());
		}
		// 정렬
		Arrays.sort(len);
		// 이분 탐색
		long min = 1;
		long max = len[k-1];
		long output = 0;
		while(min<=max) {
			// mid 길이로 만들 수 있는 랜선 개수 구하기
			long mid = (max+min)/2;
			long sum = 0;
			for(int i=0; i<k; i++) {
				sum = sum + len[i]/mid;
			}
			// 판정
			if(sum>=n) {			// n개 이상 만들수 있으면
				output = mid;
				min = mid+1;		// 최솟값 +1로 다시 시도
			}
			else					// 만들수 없으면
				max = mid-1;		// 최댓값 -1로 다시 시도
		}
		// 출력
		System.out.print(output);
	}
}