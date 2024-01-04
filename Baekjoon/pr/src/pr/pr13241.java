// 백준 13241번
// 최소공배수
// 두 정수의 최소공배수를 출력
// 유클리드 호제법을 사용하는 문제
// long타입을 사용할 것.
// 방법-------------------------
// 두 정수 a, b를 입력 받고
// 유클리드 호제법을 이용해 최대공약수를 구한다.
// 최대공약수를 이용해 최소공배수를 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr13241 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		// 최소공배수 구하기, 출력
		System.out.print(a*b/cal(a,b));
	}

	// 최대공약수 구하기
	// c = a를 b로 나눈 나머지
	public static long cal(long a, long b) {
		while(b != 0) { // c가 0이 될 때
			long c = a%b;
			a=b;
			b=c;
		}
		return a;
	}
}