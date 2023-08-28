// 백준 2720번
// 거스름돈 최소 동전 개수 문제
// 방법------------------
// 테스트 케이스의 개수 T를 한 줄 입력 받고
// 거스름돈 C를 T줄에 걸쳐 받고
// 각각 어떤 동전을 몇개 줘야하는지를 if문을 여러개 이용해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int input = Integer.parseInt(br.readLine());
		for (int x = 0; x < input; x++) {
			int change = Integer.parseInt(br.readLine());
			int[] coin = new int[4];
			// 최소 동전 개수 구하기
			if (change / 25 != 0) { // 거스름돈이 $0.25 미만이 아니라면
				coin[0] = change / 25; // 쿼터의 개수
				change -= (25 * coin[0]);
			}
			if (change / 10 != 0) { // 거스름돈이 $0.10 미만이 아니라면
				coin[1] = change / 10; // 다임의 개수
				change -= (10 * coin[1]);
			}
			if (change / 5 != 0) { // 거스름돈이 $0.05 미만이 아니라면
				coin[2] = change / 5; // 니켈의 개수
				change -= (5 * coin[2]);
			}
			if (change / 1 != 0) {
				coin[3] = change / 1; // 페니의 개수
				change -= coin[3];
			}
			// 최종 출력
			for (int y = 0; y < coin.length; y++) {
				System.out.print(coin[y] + " ");
			}
			System.out.println();
		}
	}
}