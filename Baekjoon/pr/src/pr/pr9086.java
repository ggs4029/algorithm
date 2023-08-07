// 백준 9086번
// 문자열을 입력받아 첫글자와 마지막 글자를 출력
// 방법----------------------------------
// 첫번째로 테스트 케이스의 개수 t를 입력받고
// 두번째로 문자열들을 입력받는다
// 입력 받은 문자열의 첫글자와 마지막 글자를 출력한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int x=0; x<t; x++) {
			String s = br.readLine();
			if(s==null || s.equals(""))
				System.out.println("");
			else {
				System.out.print(s.charAt(0));
				System.out.println(s.charAt(s.length()-1));
			}
		}
		br.close();
	}
}