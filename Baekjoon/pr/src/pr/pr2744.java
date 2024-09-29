// 백준 2744번
// 문자열 입력 받아 대소문자 반대로 바꾸기
// 방법---------------------
// 문자열을 입력 받고 대문자는 소문자로 소문자는 대문자로 바꾸어 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 대소문자 바꾸고 출력
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i)>='a' && input.charAt(i)<='z') {
				System.out.print((char)(input.charAt(i)-32));
			}
			else {
				System.out.print((char)(input.charAt(i)+32));
			}
		}
	}
}