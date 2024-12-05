// 백준 1074번
// 한수는 크기가 2^N × 2^N인 2차원 배열을 Z모양으로 탐색하려고 함.
// N > 1인 경우, 배열을 크기가 2^(N-1) × 2^(N-1)로 4등분 한 후에 재귀적으로 순서대로 방문.
// N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 문제.
// 방법---------------------
// 첫 줄에 n, r, c가 주어짐. (r행 c열)
// 재귀 메소드를 이용해 r행 c열을 몇 번째로 방문하는지 출력한다.
// 4분면으로 나눠 재귀 호출 하도록 코드를 짬.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1074 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		// 메소드 호출
		z((int) Math.pow(2, n), r, c);
		// 출력
		System.out.print(output);
	}

	// 방문 순서를 찾는 재귀함수 z
	public static int output = 0;
	public static void z(int n, int r, int c) {
		if(n==1)
			return;
		if(r<n/2 && c<n/2)								// 2사분면
			z(n/2, r, c);
		else if(r<n/2 && c>=n/2) {						// 1사분면
			output += n * n / 4;
			z(n/2, r, c - n/2);
		}
		else if(r>=n/2 && c<n/2) {						// 3사분면
			output += (n * n / 4) * 2;
			z(n/2, r - n/2, c);
		}
		else{											// 4사분면
			output += (n * n / 4) * 3;
			z(n/2, r - n/2, c - n/2);
		}
	}
}