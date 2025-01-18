// 백준 17103번
// 짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다.
// 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자.
// 두 소수의 순서만 다른 것은 같은 파티션이다.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받음.
// 각 테스트 케이스마다 짝수 n을 입력 받음.
// 일단 에라토스테네스의 체로 소수부터 구해두고
// j랑 n-j 둘다 소수면 카운트 하는 식으로 골드바흐 파티션의 개수를 구하고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17103 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] prime = new boolean[1_000_000+1];
		prime[0] = false;
		prime[1] = false;
		for(int i=2; i<=1_000_000; i++)
			prime[i] = true;
		// 소수 구하기 - 에라토스테네스의 체
		for(int i=2; i*i<=1_000_000; i++) {
			if(prime[i]) {
				for(int j=i*i; j<=1_000_000; j+=i)
					prime[j] = false;
			}
		}
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			int output = 0;
			for(int j=2; j<=n/2; j++) {
				if (prime[j] && prime[n-j])
					output++;
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}