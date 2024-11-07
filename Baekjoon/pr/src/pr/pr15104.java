// 백준 15104번
// . 제외한 문자열에서 팰린드롬이 홀수면 Odd. 출력
// 아니면 Or not. 출력하는 문제.
// 방법---------------------
// 첫 줄에 문자열이 주어짐.
// . 지우고 홀수 길이인지 팰린드롬 검사 후
// 짝수 길이 팰린드롬이 있으면 Or not. 출력 아니면 Odd. 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15104 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// . 제거
		input = input.replace(".", "");
		// 홀수 길이인지 팰린드롬 검사
		boolean even = false;
		for(int i=1; i<=input.length(); i++) {
			for(int j=0; j<=input.length()-i; j++) {
				String tmp = input.substring(j, j + i);
				if (palin(tmp, 0, tmp.length() - 1) && i % 2 == 0) { // 짝수 길이의 팰린드롬이면
					even = true;
					break;
				}
			}
			if(even)
				break;
		}
		// 출력
		if(even)
			System.out.print("Or not.");
		else
			System.out.print("Odd.");
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