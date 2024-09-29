// 백준 15964번
// A＠B = (A+B)×(A-B) 구하기
// 방법---------------------
// 첫째 줄에 a, b가 주어지면 A＠B 구해 출력하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15964 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		long a = Integer.parseInt(input[0]);
		long b = Integer.parseInt(input[1]);
		//출력
		System.out.print((a+b)*(a-b));
	}
}