// 백준 11478번
// 서로 다른 부분 문자열의 개수 구하기
// 방법-----------------------
// 문자열 s를 입력 받고
// 집합과 이중for문을 이용하여 모든 부분 문자열들을
// 중복 없이 add한 다음 개수를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class pr11478 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String s = br.readLine();
		Set<String> all_s = new HashSet<>();
		// 모든 부분 문자열 add
		for(int x=0; x<s.length(); x++) {
			for(int y=x+1; y<=s.length(); y++) {
				//System.out.println(s.substring(x,y));
				all_s.add(s.substring(x, y));	// x번째부터 y번째 문자까지
			}
		}
		// 출력
		System.out.print(all_s.size());
	}
}