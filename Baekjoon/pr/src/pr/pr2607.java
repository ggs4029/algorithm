// 백준 2607번
// 입력으로 여러 개의 서로 다른 단어가 주어질 때, 첫 번째 단어와 비슷한 단어가 모두 몇 개인지 찾아 출력하는 프로그램을 작성.
// 영문 알파벳 대문자로 이루어진 두 단어가 다음의 두 가지 조건을 만족하면 같은 구성을 갖는다고 말함.
// 1. 두 개의 단어가 같은 종류의 문자로 이루어져 있다.
// 2. 같은 문자는 같은 개수 만큼 있다.
// 방법---------------------
// 첫 줄에 단어의 개수 n이 주어짐.
// 둘째 줄부터 n줄에 걸쳐 단어들이 주어진다.
// 배열로 알파벳 하나하나 세며 같은 문자가 몇개 있는지 세고
// 같은 구성, 교체, 제거, 추가 에 해당되는지 검사한 후 비슷한 단어의 개수를 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pr2607 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int output = 0;
		for(int i=0; i<n-1; i++) {
			String input2 = br.readLine();
			int tmp = 0;								// 같은 문자 개수 저장할 변수
			int[] word = new int[26];
			// 첫번째 단어 문자 개수 세기
			for(int j=0; j<input.length(); j++)
				word[input.charAt(j)-'A']++;
			// i번째 단어 문자 개수 세기
			for(int j=0; j<input2.length(); j++) {
				if(word[input2.charAt(j)-'A']>0) {
					word[input2.charAt(j)-'A']--;
					tmp++;
				}
			}
			// 문자열 길이 차이 구하기
			// 길이는 같고 문자 하나 다르거나 같은 경우 (교체 or 같은 구성)
			if(input.length()==input2.length() && (input.length()==tmp || input.length()-1==tmp))
				output++;
			// 짧거나 긴 경우 (제거 or 추가)
			else if(input.length()==input2.length()-1 && input2.length()-1==tmp)
				output++;
			else if (input.length()==input2.length()+1 && input2.length()==tmp)
				output++;
		}
		// 출력
		System.out.print(output);
	}
}