// 백준 11689번
// 입력 받은 문자열에서 재환이의 a의 개수가 의사가 요구하는 a의 개수보다
// 크거나 같으면 go 아니면 no를 출력하는 문제
// 방법---------------------
// 첫 줄에 재환이의 아! 를 입력받음.
// 둘째 줄에 의사가 요구하는 아! 를 입력받음.
// a개수 비교해서 답 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr4999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input1 = br.readLine();
		String input2 = br.readLine();
		// a 개수 비교
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<input1.length(); i++) {
			if(input1.charAt(i)=='a')
				sum1++;
		}
		for(int i=0; i<input2.length(); i++) {
			if(input2.charAt(i)=='a')
				sum2++;
		}
		// 출력
		if(sum1>=sum2)
			System.out.print("go");
		else
			System.out.print("no");
	}
}