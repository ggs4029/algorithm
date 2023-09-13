// 백준 2839번
// 설탕을 봉지에 담아 배달하는데
// 봉지의 종류가 3, 5kg 두가지가 있다면
// Nkg을 배달해야 할때 봉지를 제일 적게 가져가는 경우의
// 봉지 수를 출력하는 문제
// 방법---------------
// 첫째 줄에 N을 입력 받고
// 3kg 봉지 수를 x, 5kg 봉지 수를 y 라고 하면
// 3x + 5y = N이 되어야 한다.
// 중첩 for문을 돌며 이를 만족하는 x, y 값을 모두 구한 뒤
// x+y가 제일 작은 것을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 계산
		int sum = n; // n으로 초기화
		for (int x = 0; 3 * x <= n; x++) {
			for (int y = 0; 5 * y <= n; y++) {
				if (3 * x + 5 * y == n) { // 식을 만족하면
					if (x + y < sum) { // 원래 sum보다 지금 값이 더 작으면
						sum = x + y; // sum 값 교체
					}
				}
			}
		}
		// 최종 출력
		if (sum == n) // 만족하는 x, y값을 찾지 못한 경우
			System.out.print(-1);
		else
			System.out.print(sum);
	}
}