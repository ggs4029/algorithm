// 백준 21880번
// 최종 점수에 도달하기까지의 모든 가능한 점수 조합을 생성하는 문제.
// 점수를 출력하는 방식은 최종 점수 x:y로 끝나는 어떤 시나리오라도 가능하다. (스페셜저지)
// 방법---------------------
// 첫 줄에 x, y가 주어짐.
// 왼쪽부터 x를 채우고 그 다음 y를 채우는 방식으로 출력할거임.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr21880 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int a = 0;
		int b = 0;
		// 출력
		for(int i=0; i<x+y; i++) {
			if(a<x) {
				a++;
				System.out.println(a + ":" + b);
			}
			if(b<y) {
				b++;
				System.out.println(a + ":" + b);
			}

		}
	}
}