// 백준 20001번
// 수진이를 도와 고무오리를 사용해 문제 풀이를 돕는 문제.
// 고무오리 사용법은 문제 참조.
// 방법---------------------
// 첫 줄에 "고무오리 디버깅 시작" 이 주어짐.
// 다음 줄부터 "고무오리" or "문제"가 주어짐.
// "고무오리 디버깅 끝" 을 입력 받을 때까지 반복
// 문제를 잘 보고 사용법에 따라 구현.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String start = br.readLine();
		int output = 0;
		while(true) {
			String input = br.readLine();
			if(input.equals("고무오리 디버깅 끝"))
				break;
			// 고무오리로 문제 풀기
			if(input.equals("고무오리")) {
				if(output != 0)
					output--;
				else
					output += 2;
			}
			else
				output++;
		}
		// 출력
		if(output == 0)
			System.out.print("고무오리야 사랑해");
		else
			System.out.print("힝구");
	}
}