// 백준 11507번
// 현재 가지고 있는 카드를 입력 받아 잃어버린 카드의 개수를 모양별로 출력하는 문제
// 방법---------------------
// 첫 줄에 공백 없이 가지고 있는 카드들을 한줄에 입력 받음.
// 받은 문자열을 3글자씩 잘라 카운팅.
// 똑같은 카드가 존재하면 GRESKA 출력 아니면 모양별로 잃어버린 카드의 수를 한 줄에 출력
// 해시셋 이용해 중복 검사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class pr11507 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 카드 계산
		int sumP = 13, sumK = 13, sumH = 13, sumT = 13;
		HashSet<String> card = new HashSet<>();
		for(int i=0; i<input.length(); i+=3) {
			String s = input.substring(i, i+3);
			if(card.contains(s)) {						// 중복 카드면
				System.out.print("GRESKA");				// 출력 후 종료
				return;
			}
			else {										// 중복 아니면
				card.add(s);							// 해시셋에 추가하고
				if(input.charAt(i)=='P')				// 남은 카드수 계산
					sumP--;
				else if(input.charAt(i)=='K')
					sumK--;
				else if(input.charAt(i)=='H')
					sumH--;
				else
					sumT--;
			}
		}
		// 출력
		System.out.print(sumP+" "+sumK+" "+sumH+" "+sumT);
	}
}