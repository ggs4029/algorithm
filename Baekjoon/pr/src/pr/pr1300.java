// 백준 1300번
// 크기가 n * n 인 a배열이 있음.
// 배열에 들어있는 수 a[i][j] = i×j 임.
// 이 수를 일차원 배열 b에 넣으면 b의 크기는 n * n임.
// b를 오름차순 정렬했을 때, b[k]를 구하는 문제.
// 막대 과자는 자를 수 있음.
// 방법---------------------
// 첫 줄에 배열 크기 n 주어짐.
// 다음 줄에 k가 주어짐.
// b[k]에 들어갈 값을 기준으로 이분탐색하고
// k보다 작은 값의 개수들을 기준으로 포인터 옮겨가면서
// 최솟값 찾아 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Long.parseLong(br.readLine());
		long k = Long.parseLong(br.readLine());
		// 이분 탐색
		long left = 1;													// 최소값
		long right = n * n;
		while(left <= right) {
			long mid = (left + right) / 2;
			long tmp = 0;												// mid보다 작은 수의 개수
			for(int i=1; i<=n; i++)
				tmp += Math.min(mid / i, n);
			if(tmp < k)													// 개수가 k개 미만이면
				left = mid + 1;											// 왼쪽 포인터 오른쪽으로 옮기고 다시
			else {														// 개수가 k개 이상이면
				right = mid - 1;										// 오른쪽 포인터 왼쪽으로 줄이고 다시
			}
		}
		// 출력
		System.out.print(left);
	}
}