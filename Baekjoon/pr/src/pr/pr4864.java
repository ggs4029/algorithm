// 백준 4864번
// 문제에서 주어진 계산법에 의한
// 주어진 일수에 대해 가시가 받은 총 금화 수를 출력하는 문제.
// 방법---------------------
// 매 줄마다 입력을 정수로 받고(0이 들어올때까지)
// 금화수를 for문을 돌며 계산하고 나중에 한번에 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr4864 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			// 금화 계산
			int sum = 0;
			int tmp;											// 오늘 지급할 금화 수
			int day = 0;										// 날짜 세기
			for(tmp=1; day<n; tmp++) {
				for(int i=0; i<tmp && day<n; i++) {
					sum += tmp;
					day++;
				}
			}
			sb.append(n).append(" ").append(sum).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}