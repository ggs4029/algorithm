// 백준 1934번
// 최소공배수 구하기
// 방법-------------------
// 최소공배수 = A * B / 최대공약수 이므로
// 최소공약수를 구한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int x = 0; x < t; x++) {
			// 입력
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			// 최소공약수 구하기
			int c = 1;
			if (a > b) { // a가 b보다 크면 for문이 b까지만 돌음
				for (int y = c + 1; y <= b; y++) {
					if ((a % y == 0) && (b % y == 0)) { // 둘다 y로 나눠지면 최소공약수로
						c = y;
					}
				}
			}
			else { // b가 a보다 크면 for문이 a까지만 돌음
				for (int y = c + 1; y <= a; y++) {
					if ((a % y == 0) && (b % y == 0)) { // 둘다 y로 나눠지면 최소공약수로
						c = y;
					}
				}
			}
			// 최종 출력
			System.out.println(a * b / c);
		}

	}
}