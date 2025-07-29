// 백준 2749번
// n이 주어지면 n번째 피보나치 수를 100만으로 나눈 나머지를 출력하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// n의 범위가 매우 크므로 피사노 주기를 활용.
// 문체 출력칸에 100만으로 나눈 나머지를 출력하라하였으므로
// n번째 피보나치 수를 m으로 나눈 나머지는 n%p번째 피보나치 수를 m으로 나눈 나머지와 같음.
// 즉 주기 p가 150만이고 이를 이용해 n번째 피보나치 수를 100만으로 나눈 나머지를 구해 출력.
// 오답노트-------------------
// n%p가 0인 경우를 고려 안하고
// fibo배열을 만들면 배열의 크기가 1이되어
// fibo[1] = 1 하였을때 오류가남.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2749 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Long.parseLong(br.readLine());
		// 피보나치 수 구하기
		int mod = 1_000_000;
		int p = 1_500_000;
        if((int)(n%p) == 0) {
            System.out.print(0);
            return;
        }
		long[] fibo = new long[(int)(n%p + 1)];
		fibo[0] = 0; fibo[1] = 1;
		for(int i=2; i<fibo.length; i++)
			fibo[i] = (fibo[i-1] + fibo[i-2]) % mod;
		// 출력
		System.out.print(fibo[(int)(n%p)]);
	}
}