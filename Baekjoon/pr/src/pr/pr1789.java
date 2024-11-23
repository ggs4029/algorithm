// 백준 11689번
// 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
// 방법---------------------
// 첫 줄에 s가 입력으로 주어짐.
// n의 최댓값은 1부터 n까지 더했을때 200을 넘지않는 그 최댓값 n이 답임.
// 따라서 while문 돌며 n을 구한다. ------> 시간초과
// n(n+1)/2가 s를 넘지 않는 그 최댓값 n을 구한다.
// 즉 n(n+1) = 2s 이므로 근의 공식을 사용해 n 구하기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long s = Long.parseLong(br.readLine());
		// n 구하기 - n(n+1) = 2s의 해 구하기 (근의 공식 이용)
		long n = (long) ((-1 + Math.sqrt(1 + 8*s)) / 2);
		// 출력
		System.out.print(n);
	}
}