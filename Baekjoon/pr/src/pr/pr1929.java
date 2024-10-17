// 백준 3373번
// M이상 N이하의 소수를 모두 출력하는 문제
// 방법---------------------
// 첫 줄에 m과 n을 입력 받음.
// 에라토스테네스의 체 알고리즘을 이용해 시간초과 없이 소수 찾기.
// print대신 StringBuilder 사용.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		// 소수 구하기 - 에라토스테네스의 체
		boolean[] prime = new boolean[n+1];
		for(int i=2; i<=n; i++)
			prime[i] = true;							// 모두 소수로 설정(기본)
		for(int i=2; i*i<=n; i++) {						// 2부터 n의 제곱근까지 반복
			if(prime[i]) {								// 소수면
				for(int j=i*i; j<=n; j+=i)				// i의 배수를 모두
					prime[j] = false;					// false (소수 아님)
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = Math.max(m, 2); i<=n; i++) {
			if(prime[i])
				sb.append(i).append("\n");
		}
		System.out.print(sb.toString());
	}
}