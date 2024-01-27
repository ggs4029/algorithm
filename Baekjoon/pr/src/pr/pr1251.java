// 백준 1251번
// 단어 나누기
// 단어를 임의로 세 부분으로 쪼개고
// 쪼개진 단어들을 뒤집은 뒤 다시 합칠때
// 이렇게 만들 수 있는 단어 중에서 사전순으로 가장 앞서는 단어를 구하는 문제
// 방법--------------------------
// 단어를 입력 받고
// 이중for문을 돌며 단어를 나눌수 있는 모든 경우의 수를 구하고
// 뒤집은 뒤 연결리스트에 add한다.
// 정렬해서 사전순으로 만들고 제일 앞에 있는 단어를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class pr1251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		List<String> output = new LinkedList<>();
		for(int x=2; x<input.length(); x++) {
			for(int y=1; y<x; y++) {
				StringBuilder sb1 = new StringBuilder(input.substring(0,y));	// 부분1
				StringBuilder sb2 = new StringBuilder(input.substring(y,x));	// 부분2
				StringBuilder sb3 = new StringBuilder(input.substring(x));		// 부분3
				// 연결 리스트에 추가
				output.add(sb1.reverse().toString()+sb2.reverse().toString()+sb3.reverse().toString());
			}
		}
		// 정렬
		Collections.sort(output);
		// 출력
		System.out.print(output.get(0));
	}
}