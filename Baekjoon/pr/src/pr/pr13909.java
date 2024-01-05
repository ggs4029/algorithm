// 백준 13241번
// 창문 닫기
// n개의 창문과 n개의 사람이 있을 때
// n번째 사람이 n의 배수의 창문을 열려있으면 닫고 닫혀있으면 열을 때
// 마지막에 열려 있는 창문의 개수 구하기.

/* 방법----------------------
 * 창문이 열려 있는 경우 : 창문을 홀수번 건드렸을 때
 * 창문이 닫혀 있는 경우 : 창문을 짝수번 건드렸을 때
 * 이므로 홀수번 건드리는 경우를 찾으면 된다.
 *
 * 1번째 창문 -> 홀수번 sum++
 * 2번째 창문 1,2번째 사람이 건드림 -> 짝수번 탈락
 * 3번째 창문은 1, 3번째 사람이 건드림 -> 짝수번 탈락
 * 4번째 창문은 1, 2, 4번째 사람이 건드리고 -> 홀수번이므로 sum++
 * 5번째 창문은 1, 5번째 사람이 건드리고 -> 짝수번 탈락
 * 6번째 창문은 1, 2, 3, 6번째 사람이 건드림 -> 짝수번 탈락
 * 이를 쭉 해서 1, 4, 9, 16처럼 n^2들만 홀수가 된다는 것을 알게되었다.
 *
 * 즉 n을 입력 받고
 * for문을 돌며 n이하의 제곱수의 수를 구해 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr13909 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		long n = Long.parseLong(st.nextToken());
		// n이하의 제곱수의 수 구하기
		long sum = 0;
		for(long x=1; x*x<=n; x++) {
			sum++;
		}
		//출력
		System.out.print(sum);
	}
}