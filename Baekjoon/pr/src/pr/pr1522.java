// 백준 1522번
// a와 b로만 이루어진 문자열이 주어질 때,  a를 모두 연속으로 만들기 위해서 필요한 교환의 회수를 최소로 하는 프로그램 작성하기.
// 이 문자열은 원형이기 때문에, 처음과 끝은 서로 인접해 있는 것이다.
// 예를 들어, aabbaaabaaba이 주어졌을 때, 2번의 교환이면 a를 모두 연속으로 만들 수 있다.
// 방법---------------------
// 첫 줄에 문자열이 주어짐.
// 배열리스트 전체를 순회하며
// a구간 안에서 b의 최소 개수를 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class pr1522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		ArrayList<Character> s = new ArrayList<>();
		int a = 0;
		for(int i=0; i<input.length(); i++) {
			s.add(input.charAt(i));
			if (s.get(i)=='a')
				a++;
		}
		// 최소 교환 횟수 구하기
		int output = 1557;
		for(int i=0; i<s.size(); i++) {
			int b = 0;
			for(int j=0; j<a; j++) {					// tmp 길이 안에서 b 개수 세기
				if(s.get((i+j)%s.size())=='b')			// 원형 순회
					b++;
			}
			output = Math.min(output, b);
		}
		// 출력
		System.out.print(output);
	}
}