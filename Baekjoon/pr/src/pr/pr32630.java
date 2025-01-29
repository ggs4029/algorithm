// 백준 17392번
// 크기가 n인 배열이 주어진다. 이 배열에 다음과 같은 연산을 최대 한 번 적용할 수 있다.
// 배열의 서로 다른 두 원소 a, b를 선택해서 두 원소를 모두 a*b로 바꿈.
// 연산을 최대 한 번 적용하였을 때 배열의 합의 최댓값을 구해보자.
// 방법---------------------
// 첫 줄에 배열 크기 n이 주어지고
// 두번째 줄에 배열의 원소들이 주어진다.
// 최소값 두개랑 최댓값 두개로 계산한 경우
// 두가지로 나누어 계산하고 최댓값 출력
// 최솟값 두개가 음수면 -> 최댓값 갱신 가능

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr32630 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] num = new long[n];
		long sum = 0;
		for(int i=0; i<n; i++) {
			num[i] = Long.parseLong(st.nextToken());
			sum += num[i];
		}
		// 정렬
		Arrays.sort(num);
		// 배열의 합의 최댓값 구하기
		long output = 0;
		output = Math.max(sum, sum - num[n-1] - num[n-2] + num[n-1] * num[n-2] * 2);	// 최댓값 두개로 계산
		output = Math.max(output, sum - num[0] - num[1] + num[0] * num[1] * 2);			// 최솟값 두개로 계산
		// 출력
		System.out.print(output);
	}
}