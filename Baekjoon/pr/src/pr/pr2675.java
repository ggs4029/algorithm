// 백준 2675번
// 문자열 s를 입력받고
// 각 문자를 r번 반복해 새 문자열 p를 만들기
// 방법-----------------------------
// 테스트 케이스 t를 첫번째로 입력 받고
// 반복횟수 r과 문자열 s를 같이 입력 받는다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 t 입력 받기
		int t = Integer.parseInt(br.readLine());
		for(int x=0; x<t; x++) {
			// 반복횟수 r과 문자열 s입력받기
			String[] input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			String[] s = input[1].split("");
			// 출력
			for(int y=0; y<s.length; y++) {
				for(int z=0; z<r; z++)
					System.out.print(s[y]);
			}
			System.out.println();
		}
	}
}