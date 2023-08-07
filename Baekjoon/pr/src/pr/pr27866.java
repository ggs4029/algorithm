// 백준 27866번
// 단어 s와 정수 i가 주어지면 s의 i번째 글자 출력
// 방법----------------------------------
// 단어 s를 입력받고
// 정수 i를 입력받는다
// s의 i번째 글자를 출력한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr27866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("");
		int i = Integer.parseInt(br.readLine());
		System.out.print(s[i-1]);
	}
}
