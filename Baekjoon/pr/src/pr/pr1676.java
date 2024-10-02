// 백준 1676번
// N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 문제
// 방법---------------------
// n을 입력 받는다.
// 10 = 2 * 5 이므로 2와 5의 쌍의 개수를 찾아야함
// 		--> 5의 개수만 세면 M을 구할 수 있음.
// for문을 돌며 n!에 있는 5의 개수를 찾아 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// m 계산
		int m = 0;
		for (int i=5; i<=n; i=i*5) {
			m = m + n/i;
		}
		// 출력
		System.out.print(m);
	}
}