// 백준 4948번
// 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 문제.
// 방법---------------------
// 첫 줄에 n을 입력 받음.
// 에라토스테네스의 체 이용해 문제 범위 내의 소수들을 구하고
// n ~ 2n 사이의 소수 개수 세서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr4948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int max = 123456;
		boolean[] prime = new boolean[2*max+1];
		prime[0] = false;
		prime[1] = false;
		for(int i=2; i<=2*max; i++)
			prime[i] = true;
		// 소수 구하기 - 에라토스테네스의 체
		for(int i=2; i*i<=2*max; i++) {
			if(prime[i]) {
				for(int j=i*i; j<=2*max; j+=i)
					prime[j] = false;
			}
		}
		while(true) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			// 소수 세기
			int output = 0;
			for(int i=n+1; i<=2*n; i++) {
				if(prime[i])
					output++;
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}