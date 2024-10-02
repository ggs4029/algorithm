// 백준 9693번
// N이 주어졌을 때, N!/10M이 정수가 되는 M 중 가장 큰 것을 출력하는 문제
// 방법---------------------
// 0이 입력으로 들어오기 전까지 매 줄마다 N을 입력 받는다.
// 10 = 2 * 5 이므로 2와 5의 쌍의 개수를 찾아야함
// 		--> 5의 개수만 세면 M을 구할 수 있음.
// for문을 돌며 n!에 있는 5의 개수를 찾아 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9693 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int output = 1;
		while(true) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			// 0입력 -> 종료
			if(n==0)
				break;
			// m 계산
			int m = 0;
			for (int i=5; i<=n; i=i*5) {		// 5, 25, 125 ''' 돌며 5가 들어가있는 개수 셈
                m = m + n/i;
            }
			// 출력
			System.out.printf("Case #%d: %d\n", output++, m);
		}
	}
}