// 백준 1110번
// 더하기 사이클
// n이 주어졌을 때, n의 사이클의 길이를 구하는 문제
// 방법----------------------------------
// n을 입력 받고
// 무한루프를 돌며 왼쪽자리 수와 오른쪽자리 수를 나눠 구하고
// 이를 통해 새로운 수를 만든다.
// 새로운 수가 n과 같아질때까지 무한루프를 돌고
// 사이클의 길이를 구해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 사이클의 길이 구하기
		int a = n;
		int output = 0;
		while(true) {
			int b = n/10;					// 왼쪽자리 수
			int c = n%10;					// 오른쪽자리 수
			n = c*10 + (b+c)%10;			// 새로운 수
			output++;
			if(a==n)						// a랑 n이 같아지면
				break;						// 사이클이 끝남
		}
		// 출력
		System.out.print(output);
	}
}