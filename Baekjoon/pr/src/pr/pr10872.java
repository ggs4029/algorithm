// 백준 10872번
// 팩토리얼
// 방법--------
// n을 입력 받고
// 재귀함수를 통해 n!의 값을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10872 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// n!계산 + 출력
		System.out.print(factorial(n));
	}

	public static int factorial(int n) {
		if(n==1) {
			return n;
		}
		else if(n==0) {
			return 1;
		}
		else {
			return factorial(n-1)*n;
		}
	}
}