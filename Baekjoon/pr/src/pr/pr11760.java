// 백준 11760번
// 추측한 코드에 대해 피드백 r, s를 출력하는 문제.
// r = 코드와 추측 모두에서 색상과 위치가 동일한 핀의 수
// s = 동일한 색상이지만 위치가 다른 핀의 수
// 방법---------------------
// 첫 줄에 코드의 길이 n과 두개의 문자열이 주어진다.
// 첫번째 문자열은 코드이고 두번째 문자열은 추측임.
// 해시맵 사용
// for문을 돌며 자릿수 비교로 r 구하기
// 해시맵을 이용해 추측해시맵을 돌며 s 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class pr11760 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		String code = input[1];
		String guess = input[2];
		HashMap<Character, Integer> cHash = new HashMap<>();
		HashMap<Character, Integer> gHash = new HashMap<>();
		// r 구하기
		int r = 0;
		for(int i=0; i<n; i++) {
			if(code.charAt(i)==guess.charAt(i))						// 위치와 색상이 동일하면
				r++;
			else {													// 동일하지 않으면
				cHash.put(code.charAt(i), cHash.getOrDefault(code.charAt(i), 0) + 1);
				gHash.put(guess.charAt(i), gHash.getOrDefault(guess.charAt(i), 0) + 1);
			}
		}
		// s 구하기
		int s = 0;
		for(char c : gHash.keySet()) {
			if(cHash.containsKey(c))
				s += Math.min(cHash.get(c), gHash.get(c));
		}
		// 출력
		System.out.print(r+" "+s);
	}
}