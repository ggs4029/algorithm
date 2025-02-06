// 백준 32951번
// 첫 번째 줄에 n년으로부터 몇 년이나 지났는지 출력하는 문제.
// 방법---------------------
// 입력 받고 2024 빼서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32951 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int input = Integer.parseInt(br.readLine());
		// 출력
		System.out.print(input-2024);
	}
}