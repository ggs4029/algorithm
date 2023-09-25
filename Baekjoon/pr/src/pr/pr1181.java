// 백준 1181번
// 알파벳 소문자로 이루어진 n개의 단어를 입력 받아
// 길이가 짧은 순 + 길이가 같으면 사전 순으로 출력
// 중복된 단어는 하나만 남기고 나머진 제거
// 방법----------------------------
// 첫째 줄에 단어의 개수 n을 입력 받고
// n줄에 걸쳐 알바펫 소문자로 이루어진 단어들을 입력 받는다.
// 배열을 만들어 입력 받은 단어들을 넣되, if문을 이용해 중복되는 단어면 넣지 않는다.
// Arrays.sort에서 Comparator를 단어의 길이를 먼저 비교하도록 만든다.
// 이렇게 정렬된 배열을 출력할때는 바로 앞의 인덱스와 비교해서
// 중복되는 값은 버리고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class pr1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n과 단어 입력
		int n = Integer.parseInt(br.readLine());
		String[] word = new String[n];
		for (int x = 0; x < n; x++) {
			word[x] = br.readLine();
		}
		// 정렬
		Arrays.sort(word, new Comparator<String>() {
			@Override
			public int compare(String input1, String input2) {
				if (input1.length() == input2.length()) { // 단어 길이가 같을 때
					return input1.compareTo(input2);
				} else { // 단어 길이가 다를 때
					return input1.length() - input2.length();
				}
			}
		});
		// 출력
		System.out.println(word[0]);
		for (int x = 1; x < n; x++) {
			if (!word[x].equals(word[x - 1])) { // 중복이지 않으면 출력
				System.out.println(word[x]);
			}
		}
	}
}