// 백준 15725번
// 최대 일차 일변수 다항식이 주어졌을 때 그 함수를 미분한 결과를 출력하는 문제
// 방법---------------------
// 첫째 줄에 최대 일차 일변수 다항식이 주어진다.
// 다항식 미분한 결과를 출력.
// if문으로 모든 상황에 대해 답을 구함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// 미분에 대한 답 구하기 + 출력
		if(input.contains("x")) {
			int tmp = 0;
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i)=='x')
					tmp = i;
			}
			if(input.charAt(0)=='x')
				System.out.print(1);
			else if(input.contains("-x"))
				System.out.print(-1);
			else {
                String tmp2 = input.substring(0, tmp).trim();
                System.out.print(Integer.parseInt(tmp2));
			}
		}
		else
			System.out.print(0);
	}
}