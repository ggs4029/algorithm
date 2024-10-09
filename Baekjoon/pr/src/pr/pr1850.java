// 백준 1850번
// 모든 자리가 1로만 이루어져있는 두 자연수에 대해 최대공약수 구해 출력하기
// 방법---------------------
// 첫 줄에 a와 b를 이루는 1의 개수를 입력 받는다.
// 입력 받은 두 수의 최대공약수만큼 1 찍어 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1850 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		long a = Long.parseLong(input[0]);
		long b = Long.parseLong(input[1]);
		// gcd 구하기
		StringBuilder sb = new StringBuilder();
		if(a>=b) {						// a가 더 큰 경우
			while(b>0) {
				long tmp = a;
				a = b;
				b = tmp%b;
			}
			for(long i=0; i<a; i++)
				sb.append("1");
		}
		else {							// b가 더 큰 경우
			while(a>0) {
				long tmp = b;
				b = a;
				a = tmp%a;
			}
			for(long i=0; i<b; i++)
				sb.append("1");
		}
		//  출력
		System.out.print(sb.toString());
	}
}