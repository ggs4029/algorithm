// 백준 10769번
// 승엽이가 보낸 이모티콘에서 행복한 얼굴 이모티콘과 슬픈 얼굴 이모티콘의 개수를 세어
// 승엽이의 상태를 출력하는 문제.
// 방법---------------------
// 첫 줄에 최대 255개의 문자들이 한줄에 입력된다.
// 문자열에서 서브스트링 긁어서 이모티콘 개수를 세고
// 개수에 따라서 그에 맞는 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10769 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 행복한지 슬픈지 판별
		int happy = 0; int sad = 0;
		// 문자열을 순차적으로 확인
		for(int i=0; i<=input.length()-3; i++) {
			if(input.substring(i, i + 3).equals(":-)"))
				happy++;
			else if(input.substring(i, i + 3).equals(":-("))
				sad++;
		}
		// 출력
		if(happy==0 && sad==0)
			System.out.print("none");
		else if(happy==sad)
			System.out.print("unsure");
		else if(happy>sad)
			System.out.print("happy");
		else
			System.out.print("sad");
	}
}