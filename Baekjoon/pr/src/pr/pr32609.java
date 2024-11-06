// 백준 32609번
// 정확히 s개의 팰린드롬 부분 문자열을 포함하는 문자열을 s만 입력 받고 구하는 문제.
// 방법---------------------
// 첫 줄에 정수 s를 입력 받음.
// a = 1
// aa = 3
// aaa = 6
// aaaa = 10 이므로 a만 늘려나가면 일반항 a(n) = n(n+1)/2
// s > a(n)인 제일 큰 n구하고 s - a(n)만큼 b~z를 뒤에 붙여주면 끝.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long s = Long.parseLong(br.readLine());
		// s > a(n)인 제일 큰 n구하기
		long n = 0;
		for(n=1; n*(n+1)/2<=s; n++) {
		}
		n = n-1;									// n은 s를 초과하는 첫번째 값이므로 n-1로 수정
		// 문자열 구하기
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++)						// n번 a 추가
			sb.append("a");
		long tmp = s - n*(n+1)/2;
		for(long i=0; i<tmp; i++)					// s - a(n)만큼 b~z를 번갈아가며 추가
			sb.append((char) ('b' + (i % 25)));
		// 출력
		System.out.print(sb.toString());
	}
}