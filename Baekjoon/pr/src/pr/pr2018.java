// 백준 2018번
// 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어함.
// 이때, 사용하는 자연수는 N이하여야 한다.
// 예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다.
// 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.
// N을 입력받아 가지수를 출력하는 문제.
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// n이하의 자연수들로 이루어진 배열로
// while문을 돌며 부분합을 통해 sum=n일 경우에만 카운트해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for(int i=0; i<n; i++)
			a[i] = i+1;
		// 경우의 수 구하기
		int start = 0, end = 0;							// 두 포인터
		int sum = 0, output = 0;
		while(end<n) {
			sum += a[end];
			while(sum>n && start<=end) { 				// sum이 n보다 크면
				sum -= a[start];						// 첫 값 지우고
				start++;								// 시작 다음 값으로 옮기기
			}
			if(sum == n)
				output++;
			end++;
		}
		// 출력
		System.out.print(output);
	}
}