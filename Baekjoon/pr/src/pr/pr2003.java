// 백준 2003번
// N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다.
// 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 문제
// 방법---------------------
// 첫 줄에 n, m이 입력으로 주어짐.
// 둘째 줄에 수열 a가 주어짐.
// while문을 돌며 값을 한개씩 추가해가며 부분합을 계산해 m이 되는지 확인하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] a = new int[n];
		String[] input2 = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(input2[i]);
		// 경우의 수 구하기
		int start = 0, end = 0;
		int sum = 0, output = 0;
		while(end<n) {
			sum += a[end];
			while(sum > m && start <= end) { 			// sum이 m보다 크면
				sum -= a[start];						// 첫 값 지우고
				start++;								// 시작 다음 값으로 옮기기
			}
			if(sum == m)
				output++;
			end++;
		}
		// 출력
		System.out.print(output);
	}
}