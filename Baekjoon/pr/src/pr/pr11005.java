// 백준 11005번
// 10진수 N이 주어지면 B진법 수로 바꿔 출력하는 문제
// 방법--------------------------
// 10진법 수 N 과 B를 한줄에 입력 받고
// 나눗셈(10진수 -> N진수)를 통해 B진법 수로 바꾼다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int[] output = new int[100];
		int a = 0;
		while(true) {
			output[a] = N%B; // 나머지를 저장
			N = N/B;
			a++;
			// N/B가 0이 될때까지만 실행
			if(N==0)
				break;
		}
		// 최종출력
		// A~Z의 아스키코드 65~90
		for(int x=a-1; x>=0; x--) {
			if(output[x]>=10) {
				System.out.print((char)(output[x]+55));
			}
			else {
				System.out.print(output[x]);
			}
		}
	}
}