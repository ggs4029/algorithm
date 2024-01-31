// 백준 1343번
// 폴리오미노
// 입력 받은 X들을 남김없이 AAAA와 BB로 치환하는 문제
// 방법-----------------
// 보드판을 입력 받는다.
// replaceAll()로 XXXX를 AAAA부터 치환
// 그 다음 XX를 BB로 치환
// if문을 사용해 치환이 끝나고도 X가 남아있다면 덮을 수 없는 것이므로 -1 출력
// 아니면 그냥 답을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 문자열 변환
		String AAAA = "AAAA";
		String BB = "BB";
		input = input.replaceAll("XXXX", AAAA);		// AAAA 치환
		input = input.replaceAll("XX", BB);			// 그 후 BB 치환
		// 출력
		if(input.contains("X"))						// 치환이 끝났는데도 X가 남아있으면
			System.out.print(-1);					// -1 출력
		else
			System.out.print(input);
	}
}