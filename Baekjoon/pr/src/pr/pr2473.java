// 백준 2473번
// 연구소에서 산성 용액과 알칼리성 용액을 가지고 있음.
// 산성 용액 특성값은 양의 정수, 알칼리성 용액 특성값은 음의 정수로 나타냄.
// 같은 양의 세 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의.
// 산성 용액과 알칼리성 용액의 특성값이 주어지면
// 이 중 세 개의 서로 다른 용액을 혼합하여
// 특성값이 0에 가장 가까운 용액을 만들어내는 세 용액을 출력하는 문제.
// 방법---------------------
// 첫 줄에 용액의 수 n을 입력 받음.
// 다음 줄에 용액들의 특성값을 한 줄에 입력 받음.
// 배열 정렬하고 이분탐색을 하는데
// 포인터는 양 끝 + mid로 mid가 양 끝 사이에 위치.
// mid가 양 끝 사이를 순회하며 세 용액의 합의 절댓값을 그때마다 구하고
// 여기서 양 끝 더한게 음수면 mid를 오른쪽으로 옮겨서
// 덜 작은 값을 다음에 더하게 하고
// 양 끝 더한게 양수면 오른쪽 포인터 왼쪽으로 옮겨서
// 덜 큰 값을 다음에 더하게 함.
// mid가 한번 순회 싹하고 나면 왼쪽 포인터가 오른쪽으로 한 칸 이동.
// 최종적으로 나온 0에 가장 가까운 용액을 만들어내는 세 용액 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr2473 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		long[] num = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Long.parseLong(st.nextToken());
		// 정렬
		Arrays.sort(num);
		// 이분 탐색
		long[] output = new long[3];
		long sum = Long.MAX_VALUE;
		for(int i=0; i<n-2; i++) {
			int min = i;
			int mid = i + 1;
			int max = n - 1;
			while(mid < max) {
				long tmp = num[min] + num[mid] +  num[max];
				if(Math.abs(tmp) < sum) {									// 절댓값 더 작으면
					sum = Math.abs(tmp);
					output[0] = num[min];
					output[1] = num[mid];
					output[2] = num[max];
				}
				if(tmp < 0)													// 합해서 음수면
					mid++;													// mid를 오른쪽으로 옮기기
				else														// 양수면
					max--;													// 오른쪽 포인터 왼쪽으로 옮기기
			}
		}
		// 출력
		System.out.print(output[0] + " " + output[1] + " " + output[2]);
	}
}