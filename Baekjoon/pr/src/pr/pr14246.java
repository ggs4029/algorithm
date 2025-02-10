// 백준 14246번
// n개의 자연수로 이루어진 수열이 주어질 때
// 특정 구간 [i,j] (i≤j)의 합이 k보다 큰 모든 쌍 (i, j)의 개수를 출력하는 문제.
// 방법---------------------
// 첫 줄에 자연수의 개수 n이 주어짐.
// 다음 줄에 자연수 n개가 주어지고
// 그 다음 줄에는 k가 주어짐.
// 이중for문으로 구간 부분합 구해 k보다 큰지 검사.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr14246 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		// 구간 i,j의 합이 k보다 큰 모든 쌍의 개수 구하기
		long output = 0;
		for(int i=0; i<n; i++) {
			long tmp = 0;							// 구간의 부분합 저장할 배열
			for(int j=i; j<n; j++) {
				tmp += num[j];
				if(tmp>k) {            				// 구간 합이 k보다 크면
					output += n - j;
					break;
				}
			}
		}
		// 출력
		System.out.print(output);
	}
}