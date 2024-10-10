// 백준 18005번
// 연속된 n개의 양의 정수를 골랐는데
// 이 수들의 합이 짝수인지, 홀수인지, 또는 둘 다 가능할 수 있는지를 맞추는 문제
// 방법---------------------
// 첫 줄에 n을 입력 받음.
// 홀수 + 홀수 = 짝수
// 짝수 + 짝수 = 짝수
// 홀수 + 짝수 = 홀수 이용
// n이 홀수면 -> 홀, 짝 둘다 가능
// n이 짝수면 -> 4의 배수가 아닌 경우 -> 홀
//		 	-> 4의 배수인 경우	   -> 짝

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr18005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		if(n%2==1)
			System.out.print(0);
		else if(n%4==0)
			System.out.print(2);
		else
			System.out.print(1);
	}
}