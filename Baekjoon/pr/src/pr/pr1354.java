// 백준 1354번
// 무한 수열 A는 다음과 같다.
// Ai = 1 (i ≤ 0)
// Ai = A⌊i/P⌋-X + A⌊i/Q⌋-Y (i ≥ 1)
// N, P, Q, X, Y가 주어질 때, AN을 구하는 문제.
// 방법---------------------
// 첫 줄에 5개의 정수 N, P, Q, X, Y가 주어진다.
// 재귀와 dp 계산 위해 따로 메소드로 구현.
// 오답노트------------------
// 이미 계산한 값 재귀 들어가기 전에 containsKey 메소드 사용해 시간 줄이기.
// 조회시간 줄이기 + 중복 계산 방지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class pr1354 {

	public static HashMap<Long, Long> m = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		long n = Long.parseLong(input[0]);
		long p = Long.parseLong(input[1]);
		long q = Long.parseLong(input[2]);
		long x = Long.parseLong(input[3]);
		long y = Long.parseLong(input[4]);
		// 출력
		System.out.print(output(n, p, q, x, y));
	}

	// 결과 구하는 계산 메소드
	public static long output(long n, long p, long q, long x, long y) {
		if(n<=0)															// 문제 조건에 의해 0보다 작아지면 1리턴
			return 1;
		else if(m.containsKey(n))											// 이미 계산한 값 리턴
			return m.get(n);
		long tmp = output(n/p-x, p, q, x, y) + output(n/q-y, p, q, x, y);	// 재귀호출
		m.put(n, tmp);
		return tmp;
	}
}