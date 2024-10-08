// 백준 23304번
// 입력 받은 문자열이 아카라카 팰린드롬인지 검사해 출력하는 문제.
// 방법---------------------
// 첫 줄에 문자열 s를 입력 받음.
// 팰린드롬인지 검사하는 메소드를 만들고
// s와 접두사와 접미사 셋 다 팰린드롬인지 검사하는 아카라카 팰린드롬 검사 함수를 만들어
// 결과를 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr23304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String s = br.readLine();
		// 출력
		if (aka(s)) {
			System.out.println("AKARAKA");
		} else {
			System.out.println("IPSELENTI");
		}
	}

	// 아카라카 팰린드롬 검사 함수
	public static boolean aka(String s) {
		// s가 팰린드롬인지
		if (!palin(s, 0, s.length()-1))
			return false;
		// 길이 1이면 아카라카 팰린드롬
		if (s.length() <= 1)
			return true;
		// 접두사와 접미사 검사(재귀)
		int mid = s.length()/2;
		String l = s.substring(0, mid);
		String r = s.substring(s.length() - mid);
		return aka(l) && aka(r);
	}

	// 팰린드롬 검사 함수
	public static boolean palin(String s, int l, int r) {
		while (l<r) {
			if (s.charAt(l)!=s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
}