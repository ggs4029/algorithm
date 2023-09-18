// 백준 1032번
// 검색 결과가 주어지면
// 어떠한 명령어로 검색 했는지 패턴을 알아네 출력하는 문제
// 방법--------------------
// 파일 이름의 개수 n을 첫째 줄에 입력 받고
// 그 다음 줄부터 n줄에 걸쳐 파일 이름들을 입력 받는다.
// 입력 받은 파일 이름들을 for문을 돌며 한 글자씩 비교하며
// 같은 문자면 그대로 출력하고 다른 문자면 ?로 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1032 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] output = null;
		for (int i = 0; i < n; i++) {
			// 입력
			String[] input = br.readLine().split("");
			if (i == 0) { // 첫 입력을 받은거면
				output = input;
			}
			else {
				for (int x = 0; x < input.length; x++) {
					if (!input[x].equals(output[x])) { // 문자 비교시 다르면
						output[x] = "?"; // ?로 바꿔줌
					}
				}
			}
		}
		// 최종 출력
		for (String i : output)
			System.out.print(i);
	}
}