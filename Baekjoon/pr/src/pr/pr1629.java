// 백준 1629번
// 자연수 A를 B번 곱한 수를 알고 싶다.
// 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성.
// 방법---------------------
// 첫 줄에 a, b, c를 입력 받음.
// 거듭 제곱 계산 위해 메소드로 구현.
// c모듈러 연산 유지하면서 b가 0이 될 때 까지 b 반으로 나누어 재귀 호출.
// b/2가 홀수면 a 한번 더 곱해줌.
// 곱셈의 결과 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		// 출력
		System.out.print(mul(a, b, c));
	}

	// 거듭 제곱 계산 메소드
	public static long mul(long a, long b, long c) {
		if(b==0)
			return 1;
		long tmp = mul(a, b/2, c);					// 재귀 호출
		if(b%2==1)									// 홀수번 곱할 때
			return (tmp*tmp%c) * a%c;
		return tmp*tmp%c;							// 짝수번 곱할 때
	}
}