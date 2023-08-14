// 백준 10988번
// 팰린드롬인지 확인하기
// 팰린드롬 = 앞으로 읽을 때와 거꾸로 읽을 때가 똑같은 단어
// 방법-----------------------------
// 단어를 입력받고 배열에 한 글자씩 저장
// for문을 두번 이용해 앞으로, 뒤로 글자를 하나씩 읽어가면서
// 글자의 순서가 for문이 끝날때까지 같으면 팰린드롬
// 글자의 순서가 한번이라도 다르면 팰린드롬이 아님

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split("");
		// 팰린드롬인지 검사
		int pr=1;
		for(int x=0; x<input.length; x++) {
			if(input[x].hashCode()!=input[input.length-1-x].hashCode()) {
				pr=0;
				break;
			}
		}
		System.out.print(pr);
	}
}
