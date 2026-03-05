// 백준 27295번
// Σ(a₁xᵢ + b - yᵢ)¹ (i는 1부터 n) 의 값이
// 0에 가깝도록 하는 실수 a1을 구하는 문제.
// y절편 또한 주어진다. (b가 주어짐)
// 방법---------------------
// 첫 줄에 데이터의 개수 n과 y절편 b가 한 줄에 주어짐.
// 다음 줄부터 n줄에 걸쳐 한 줄에 하나씩 점의 좌표 xi, yi가 주어짐.
// 수식을 전개하면 결국 a1 = Σ(yi - nb) /	Σ(xi) ㅇ이고
// 이를 통해 Σ(xi)가 0인 경우와 0이 아닌 경우 두가지에 대해서 가짓수를 나눌 수 있음.
// 분모가 0이면 a1이 어떤 값이든 상관 없어짐.
// 분모가 0이 아니면 gcd 구해서 기약분수 만들고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr27295 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long sum1 = 0;
		long sum2 = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			sum1 += Long.parseLong(st.nextToken());
			sum2 += Long.parseLong(st.nextToken());
		}
		// a1 구하기
		long den = sum1;							// 분모
		long num = sum2 - (n * b);					// 분자
		// 분모가 0이면
		if(den == 0)
			sb.append("EZPZ");
		// 분모가 0이 아니면
		else {
			if(den < 0) {
				num = -num;
				den = -den;
			}
			long gcd = gcd(Math.abs(num), den);		// gcd 구해서
			num /= gcd;								// 기약분수 만들기
			den /= gcd;
			if(den == 1)
				sb.append(num);
			else
				sb.append(num + "/" + den);
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 최대공약수 구하기 - 유클리드 호제법
	public static long gcd(long a, long b) {
		while(b>0) {
			long tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}
}