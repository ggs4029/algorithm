// 백준 25344번
// 행성 n개의 행성 정렬 주기를 구하는 문제.
// 방법---------------------
// 첫 줄에 행성의 개수 n이 주어지고
// 그 다음 줄에 행성 정렬 주기가 n-2개 주어짐.
// 주기들의 최소공배수를 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr25344 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] cycle = new int[n-2];
		for(int i=0; i<n-2; i++)
			cycle[i] = Integer.parseInt(input[i]);
		// 최대공약수 구하기
		long output = cycle[0];
		for(int i=1; i<n-2; i++)
			output = lcm(output, cycle[i]);
		// 출력
		System.out.print(output);
	}

	// 최대공약수 구하기 - 유클리드 호제법
	public static long gcd(long a, long b) {
		while(b>0) {
			long tmp = a;
			a = b;
			b = tmp%b;
		}
		return a;
	}

	// 최소공배수 구하기
	public static long lcm(long a, long b) {
		return (a*b) / gcd(a, b);
	}
}