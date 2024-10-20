// 백준 19577번
// 어떤 양의 정수 n이 있다고 할 때, xφ(x) = n을 만족하는 양의 정수 x가 존재하는지,
// 존재하면 최소의 x를 존재하지 않으면 -1을 출력하는 문제.
// 오일러 피 함수란 φ(n)으로 표기하며 1부터 n까지의 양의 정수 중에서 n과 서로소인 수의 개수를 나타내는 함수.
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// xφ(x) = n  --> φ(x) = n/x 이므로 만족하려면 n/x가 정수여야함.
// 즉 x가 n의 약수여야하므로 n의 약수를 구해 최소의 x를 찾아 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr19577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Integer.parseInt(br.readLine());
		// 약수 찾기
		long output = Long.MAX_VALUE;					// 최솟값 찾기 위해 제일 큰 값으로 초기화
		for(int i=1; i*i<=n; i++) {
			if(n%i == 0) {								// i가 n의 약수면
				if(euler(i) == n/i)						// φ(x) == n/i
					output = Math.min(output, i);
				if(euler(n/i) == i)						// 약수i에 대한 쌍 n/i도 검사
					output = Math.min(output, n/i);
			}
		}
		// 출력
		if(output == Long.MAX_VALUE)					// 약수가 없었던 경우
			System.out.print(-1);						// -1 출력
		else
			System.out.print(output);
	}

	// 오일러 피 함수 - φ(x) 구하기
	public static long euler(long n) {
		long output = n;
		for(int i=2; i*i<=n; i++) {
			if (n%i == 0)
				output = output / i*(i-1);
			while(n%i == 0)
				n = n/i;
		}
		if(n == 1)
			return output;
		else
			return output / n*(n-1);
	}
}