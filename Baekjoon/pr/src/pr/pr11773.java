// 백준 11773번
// 주어진 조건에 따라 에세이 작성하기.
// 단어 수가 최소 A개, 최대 B개여야 한다.
// 각 단어는 최소 1자, 최대 15자여야 한다.
// 사용된 어휘가 충분히 다양해야 하며, 즉 에세이에 최소 B/2개의 서로 다른 단어가 포함되어야 한다.
// 방법---------------------
// 첫 줄에 a, b가 주어짐.
// 나누기 이용해 매번 다른 소문자 단어(사실은 알파벳)들을 생성해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		// 단어 생성
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<(a+b)/2; i++) {
			int tmp = i;
			StringBuilder sb2 = new StringBuilder();
			while(true) {
				sb2.append((char) ('a' + tmp % 26));
				tmp = tmp/26;								// 26 넘어가면 단어의 자리수 추가
				if(tmp == 0)
					break;
			}
			sb.append(sb2.toString()).append(" ");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}