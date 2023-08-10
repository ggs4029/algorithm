// 백준 1152번
// 문자열을 입력받아
// 단어의 개수를 출력
// 단어의 경우 공백으로 구분된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열 입력받기
		String[] s = br.readLine().split(" ");
		if(s==null || s.length==0)
			System.out.println(0);
		else if(s[0]=="")
			System.out.println(s.length-1);
		else
			System.out.println(s.length);
	}
}