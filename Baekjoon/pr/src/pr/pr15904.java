// 백준 15904번
// 문자열이 주어지면 적절히 축약해서 UCPC를 만들수 있는지 알아내는 문제.
// 방법---------------------
// 첫줄에 문자열을 입력 받음.
// 문자열 순회하면서 UCPC로 축약 가능한지 검사하고
// 검사결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// UCPC로 축약 가능한지 검사
		char[] ucpc = {'U', 'C', 'P', 'C'};
		int tmp = 0;
		boolean output = false;
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i) == ucpc[tmp])	// 맞는 알파벳, 대소문자ㅏ면
				tmp++;							// 다음 문자 탐색
			if(tmp == 4) {
				output = true;
				break;
			}
		}
		// 출력
		if(output)
			System.out.print("I love UCPC");
		else
			System.out.print("I hate UCPC");
	}
}