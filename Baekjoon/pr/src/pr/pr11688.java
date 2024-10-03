// 백준 11688번
// 세 정수 a,b,L의 LCM(a, b, c) = L을 만족하는 c찾기
// 방법---------------------
// 첫 줄에 a, b, L 입력 받는다.
// a와 b의 최소공배수를 구한다.
// 그 값과 L이 배수인지 확인하고 배수가 아니면 -1 출력하고 종료
// 맞으면 c를 구함 - L중에서 ab(a, b의 최소공배수)에 포함되지않은 인수를 가지고 있어야함
// 주의! - "가장 작은" c를 출력해야함
// 최소공배수 구하기 - 최대공약수 활용
// 최대공약수 구하기 - 유클리드 호제법 활용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class pr11688 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		long a = Long.parseLong(input[0]);
		long b = Long.parseLong(input[1]);
		long L = Long.parseLong(input[2]);
		// a, b의 최소공배수 구하기
		long ab = lcm(a,b);
		// 인수 구하기
		long[] abs = divide(ab);
		long[] Ls = divide(L);
		// 예외 처리
		if(L%ab!=0) {
			System.out.print(-1);
			return;
		}
		if(L==ab) {
			System.out.print(1);
			return;
		}
		// ab, L중 L만 가지고 있는 인수 구하기
		long[] output = getDiv(abs, Ls);
		long num = -100;
		for(long c : output) {
			if(lcm(ab,c)==L) {
				if(c<num || num==-100)
					num = c;
			}
		}
		System.out.print(num);
	}
	// 최대공약수 구하기
	public static long gcd(long x, long y) {
		if (y == 0)
			return x;
		return gcd(y, x%y);
	}
	// 최소공배수 구하기
	public static long lcm(long x, long y) {
		return (x*y)/gcd(x,y);
	}
	// 인수 구하기
	public static long[] divide(long x) {
		ArrayList<Long> div = new ArrayList<>();
		for(long i=1; i*i<=x; i++) {
			if(x%i==0) {
				div.add(i);
				if(i!=x/i)
					div.add(x/i);
			}
		}
		long[] output = new long[div.size()];
		for(int i=0; i<div.size(); i++)
			output[i] = div.get(i);
		Arrays.sort(output);
		return output;
	}
	// 인수 중복 제거
	public static long[] getDiv(long[] x, long[] y) {
		HashSet<Long> set = new HashSet<>();
		for (long i : x) {
			set.add(i);
		}
		ArrayList<Long> output = new ArrayList<>();
		for (long i : y) {
			if (!set.contains(i))
				output.add(i);
		}
		// 배열로 변환
		long[] output2 = new long[output.size()];
		for (int i = 0; i < output.size(); i++)
			output2[i] = output.get(i);
		return output2;
	}
}