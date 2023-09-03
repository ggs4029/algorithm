// 백준 2581번
// 자연수 M과 N이 주어지면
// M이상 N이하의 자연수 중 소수인 것을 모두 골라
// 이것들의 합과 최솟값을 찾는 문제
// 방법------------------------------
// 첫째줄에 M, 둘째줄에 N을 입력 받고
// 그 사이의 소수를 중첩for문을 통해 구함과 동시에
// 최솟값과 합 또한 구한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		// 소수인지 체크
		int min = 0; // 소수들중 최솟값
		int sum = 0; // 소수들의 합
		for (int x = m; x <= n; x++) {
			int count = 0;
			for (int y = 1; y <= x; y++) {
				if (x % y == 0) { // 약수면
					count++;
				}
			}
			if (count == 2) { // 소수면
				if (min == 0) // 처음 들어오는게 최솟값
					min = x;
				sum += x;
			}
		}
		// 최종 출력
		if(sum==0) {
			System.out.print(-1);
		}
		else {
			System.out.println(sum);
			System.out.print(min);
		}
	}
}