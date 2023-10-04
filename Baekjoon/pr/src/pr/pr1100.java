// 백준 1100번
// 체스 판의 하얀 칸 위에 말이 몇개 있는지 출력하는 문제
// 방법----------------------------
// 8개의 줄로 체스판의 상태를 입력 받는다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for (int x = 0; x < 8; x++) {
			// 입력
			String[] input = br.readLine().split("");
			if (x % 2 == 0) { // 하얀칸 시작인 줄이면
				for (int y = 0; y < input.length; y++) {
					if ((y % 2 == 0) && input[y].equals("F")) {
						sum++;
					}
				}
			} else { // 검은칸 시작인 줄이면
				for (int y = 0; y < input.length; y++) {
					if ((y % 2 == 1) && input[y].equals("F")) {
						sum++;
					}
				}
			}
		}
		// 최종 출력
		System.out.print(sum);
	}
}