// 백준 25178번
// 문제에서 주어진 조건에 따라
// 주어진 두 문자열이 두라무라 효과를 발생시키는지 체크하는 문제.
// 두라무라 효과에 대해선 문제 참조.
// 방법---------------------
// 첫 줄에 단어의 길이 n이 주어짐.
// 둘째 줄과 셋째 줄에 길이 n인 알파벳 소문자로 이루어진 문자열이 주어짐.
// 주어진 조건대로 검사하고 답을 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pr25178 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String s1 = br.readLine();
		String s2 = br.readLine();
		// 문자열 빈도수 체크 - 한 단어를 재배열해 다른 단어를 만들 수 있는지
		int[] check1 = new int[26];
		int[] check2 = new int[26];
		for(int i=0; i<n; i++) {
			check1[s1.charAt(i)-'a']++;
			check2[s2.charAt(i)-'a']++;
		}
		for(int i=0; i<26; i++) {
			if(check1[i] != check2[i]) {
				System.out.print("NO");
				return;
			}
		}
		// 첫 글자 = 마지막 글자인지
		if(s1.charAt(0)==s2.charAt(0) && s1.charAt(n-1)==s2.charAt(n-1)) {
		}
		else {
			System.out.print("NO");
			return;
		}
		// 각 단어에서 모음 제거한 문자열이 동일한지
		String tmp1 = s1.replaceAll("[aeiou]", "");
		String tmp2 = s2.replaceAll("[aeiou]", "");
		// 체크하고 답 출력
		if(tmp1.equals(tmp2))
			System.out.print("YES");
		else
			System.out.print("NO");
	}
}