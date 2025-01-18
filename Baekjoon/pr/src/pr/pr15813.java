// 백준 15813번
// 사람들의 이름의 이름점수를 계산해 출력하는 문제.
// 방법---------------------
// 첫 줄에 이름 길이 n을 입력 받음.
// 다음 줄에 이름이 주어짐.
// 이름 순회하며 점수 구하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15813 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		// 이름 점수 구하기
		long output = 0;
		for(int i=0; i<n; i++)
			output += input.charAt(i)-64;
		// 출력
		System.out.print(output);
	}
}