// 백준 2420번
// 정수 입력이 두개 주어지면 거리(차의 절대값) 구하기
// 방법---------------------
// 첫째 줄에 두 유명도 n, m을 구하고 차의 절대값 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2420 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		//출력
		System.out.print(Math.abs(Long.parseLong(input[0]) - Long.parseLong(input[1])));
	}
}