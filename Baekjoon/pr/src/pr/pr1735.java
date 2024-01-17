// 백준 1735번
// 분수 합
// 분수 두개를 입력 받아 기약분수로 나타내기
// 방법----------------------------
// 두 분수를 두줄에 입력 받고
// 두 분수간의 합을 구한다.
// 분모와 분자의 최대공약수를 구한다. (유클리드 호제법 이용)
// 최대공약수를 분모와 분자에 나눠준 후 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1735 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int input1 = Integer.parseInt(st.nextToken());
		int input2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input3 = Integer.parseInt(st.nextToken());
		int input4 = Integer.parseInt(st.nextToken());
		int denominator = input1*input4+input3*input2;		// 분모
		int numerator = input2*input4;						// 분자
		int deno = denominator;
		int num = numerator;
		// gcd 구하기
		int gcd = 0;
		while(true) {
			if(denominator%numerator == 0) {
				gcd = numerator;
				break;
			}
			else {
				int d = denominator;
				denominator = numerator;
				numerator = d%numerator;
			}

		}
		// 출력
		System.out.print(deno/gcd + " " + num/gcd);
	}
}