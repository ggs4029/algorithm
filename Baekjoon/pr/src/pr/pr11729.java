// 백준 11729번
// 하노이탑 이동 순서를 출력하는 문제.
// 세 개의 장대가 있고, 첫 번째 장대에 n개의 원판이 쌓여있고 이것을 세번째 장대에 옮기는 것이 목표.
// 방법---------------------
// 첫 줄에 첫 번째 장대에 쌓인 원판 개수 n을 입력 받음.
// 옮긴 횟수 k = 2^n -1 번.
// 옮기는 순서는 맨 밑판 제외 가운데다 쌓고 맨 밑판 먼저 옮긴 뒤
// 나머지를 옮기는 식으로 재귀 메소드 짝ㅣ.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11729 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		sb.append((int)(Math.pow(2, n) - 1)).append('\n');
		hanoi(n, 1, 2, 3);
		System.out.print(sb.toString().trim());
	}

	// 재귀 메소드
	public static void hanoi(int n, int s, int mid, int e) {
		if(n == 1) {								// 원판 하나면
			sb.append(s + " " + e).append("\n");
			return;
		}
		// 이동
		hanoi(n-1, s, e, mid);						// 맨밑판 제외한 나머지 가운데로 이동
		sb.append(s + " " + e + "\n");				// 제일 큰 판을 맨 오른쪽으로 이동
		hanoi(n-1, mid, s, e);						// 나머지 판 맨 오른쪽으로 이동
	}
}