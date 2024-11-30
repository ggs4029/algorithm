// 백준 4134번
// 정수 n(0 ≤ n ≤ 4*109)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수를 찾는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받음.
// 다음 줄부터 t줄에 걸쳐 수들을 입력 받는다.
// 소수판별 메소드를 만들어 n부터 1씩 증가시키며 소수인지 검사하고 소수면 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr4134 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long t = Long.parseLong(br.readLine());
		for(long i=0; i<t; i++) {
			long n = Long.parseLong(br.readLine());
			// 소수 찾기
			if(n<=1)
				System.out.println(2);
			else {
				while(true) {
					if(isPrime(n)) {
						System.out.println(n);
						break;
					}
					n++;
				}
			}
		}
	}

	// 소수판별 메소드
	public static boolean isPrime(long n) {
		if(n==2)									// 2는 소수
			return true;
		if(n%2==0)									// 짝수는 소수가 아님
			return false;
		// 홀수인 경우 - n의 제곱근까지만 검사
		long tmp = (long) Math.sqrt(n);
		for(long i=3; i<=tmp; i+=2) {
			if(n%i==0)								// 나눠지면
				return false;						// 소수 아님
		}
		return true;
	}
}