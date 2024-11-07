// 백준 2163번
// n x m 크기의 초콜릿을 1×1 크기의 초콜릿으로 쪼개기 위한 최소 쪼개기 횟수를 구하는 문제
// 방법---------------------
// 첫 줄에 n과 m이 입력으로 주어짐.
// n*m-1 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		// 출력
		System.out.print(n*m-1);
	}
}