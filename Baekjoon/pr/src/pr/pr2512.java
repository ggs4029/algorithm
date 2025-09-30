// 백준 2512번
// 국가에서 지방에 예산을 배정할거임.
// 모든 요청이 배정될 수 있으면 요청한 대로 배정.
// 모든 요청이 배정될 수 없는 경우 특정한 정수 상한액을 계산해 그 이상인 예산요청에는 모두 상한액을 배정.
// 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정.
// 여러 지방 예산요청과 국가예산 총액이 주어지면 예산을 배정하고
// 배정된 예산들 중 최댓값인 정수를 출력하는 문제.
// 방법---------------------
// 첫 줄에 지방 수 n을 입력 받음.
// 다음 줄에는 지방의 예산 요청을 의미하는 n개의 정수가 한 줄에 주어짐.
// 맨 마지막 줄에는 총 예산 m이 주어짐.
// 예산 요청 정렬하고 이분 탐색 통해 예산 총액을 조절해가며
// 배정된 예산들 중 최댓값을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr2512 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		// 정렬
		Arrays.sort(num);
		// 이분 탐색
		long min = 1;
		long max = num[n-1];
		while(min <= max) {
			long mid = (max + min) / 2;
			long sum = 0;
			for(int i=0; i<n; i++)
				if(num[i] > mid)
					sum += mid;
				else
					sum += num[i];
			// 판정
			if(sum <= m)			// 예산이 m보다 작으면
				min = mid+1;
			else					// 예산 초과면
				max = mid-1;
		}
		// 출력
		System.out.print(max);
	}
}