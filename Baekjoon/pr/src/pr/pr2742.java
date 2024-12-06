// 백준 2742번
// 자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 문제
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// n부터 1까지 한줄에 하나씩 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2742 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		long n = Long.parseLong(br.readLine());
		for(long i=n; i>0; i--)
			sb.append(i).append("\n");
		// 출력
		System.out.print(sb.toString());
	}
}