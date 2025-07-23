// 백준 10826번
// n번쨰 피보나치 수를 구하는 문제.
// 방법---------------------
// 첫 줄에 문자열 n을 입력 받음.
// dp이용해 피보나치 수 구해 출력.
// n이 10000까지라 자료형을 빅인티져로.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class pr10826 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		if(n == 0) {
			System.out.print(0);
			return;
		}
		else if(n == 1) {
			System.out.print(1);
			return;
		}
		// 피보나치 수 구하기
		BigInteger[] fibo = new BigInteger[n+1];
		fibo[0] = BigInteger.ZERO;
		fibo[1] = BigInteger.ONE;
		for(int i=2; i<=n; i++)
			fibo[i] = fibo[i-1].add(fibo[i-2]);
		// 출력
		System.out.print(fibo[n]);
	}
}