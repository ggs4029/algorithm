// 백준 24313번
// 알고리즘의 소요 시간을 나타내는 O-표기법에서
// 문제에서 주어진 함수와 주어지는 정수들을 통해
// 정의를 만족하고 있는지 확인하는 문제
// 방법------------------------------
// 문제에서 주어진 대로 입력을 받고
// if문을 통해 정의를 만족하는지 판단 후
// 만족하면 1 아니면 0을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr24313 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input1 = br.readLine().split(" ");
		int a1 = Integer.parseInt(input1[0]);
		int a0 = Integer.parseInt(input1[1]);
		int c = Integer.parseInt(br.readLine());
		int n0 = Integer.parseInt(br.readLine());
		// 계산과 출력
		if ((a1 * n0 + a0 <= c * n0) && c >= a1) {
			System.out.print(1);
		} else {
			System.out.print(0);
		}

	}
}