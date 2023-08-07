// 백준 2743번
// 단어를 입력받고 그 길이를 출력
// 방법----------------------------------
// 단어 s를 입력받고
// 단어 s의 길이를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2743 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("");
		System.out.print(s.length);
	}
}