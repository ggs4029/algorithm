// 백준 1411번
// 어떤 단어를 숌스럽게 바꿔 또다른 언어로 만들면 그 단어는 비슷한 단어라고 한다.
// 어떤 단어를 숌스럽게 바꾼다는 말은 단어 A에 등장하는 모든 알파벳을 다른 알파벳으로 바꾼다는 소리다.
// 그리고, 단어에 등장하는 알파벳의 순서는 바뀌지 않는다.
// 두 개의 다른 알파벳을 하나의 알파벳으로 바꿀 수 없고, 임의의 알파벳을 자기 자신으로 바꾸는 것은 가능하다.
// 예를 들어, 단어 abca와 zbxz는 비슷하다. 그 이유는 a를 z로 바꾸고, b는 그대로 b, c를 x로 바꾸면, abca가 zbxz가된다.
// 단어가 여러 개 주어졌을 때, 몇 개의 쌍이 비슷한지 구하는 프로그램을 작성하시오.
// 방법---------------------
// 첫 줄에 단어 개수 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 단어들이 주어짐.
// 입력 받은 단어들을 해시맵 사용해 패턴화 시킨다. (a부터 차례대로)
// 패턴화가 끝나면 순회하며 쌍 개수 찾고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class pr1411 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] word = new String[n];
		// 입력 받은 단어 해시맵으로 패턴화 시키기
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			Map<Character, Character> m = new HashMap<>();
			char c = 'a';									// 패턴화는 a부터 시작
			String pattern = "";							// 패턴화된 문자열이 들어갈 변수
			for(int j=0; j<input.length(); j++) {
				char tmp = input.charAt(j);
				if(!m.containsKey(tmp)) {
					m.put(tmp, c);
					c++;									// 다음 알파벳
				}
				pattern = pattern.concat(String.valueOf(m.get(tmp)));
			}
			word[i] = pattern;
		}
		// 동일한 쌍 개수 세기
		int output = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(word[i].equals(word[j]))
					output++;
			}
		}
		// 출력
		System.out.print(output);
	}
}