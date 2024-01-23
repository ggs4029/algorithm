// 백준 2485번
// 가로수
// 균일하게 가로수 심기
// 방법----------------
// 첫째 줄에 이미 심어져 있는 가로수의 수 n을 입력 받고
// 둘째 줄부터 n개의 줄에 걸쳐
// 심어져있는 가로수의 위치를 입력 받고 배열에 저장한다.
// 입력 받은 배열을 정렬하고 for문을 돌면서 각 가로수들의 간격을 구한다.
// 간격을 최대한 크게하며 가로수를 심어야하므로
// 간격끼리의 최대공약수를 구하며 for문을 돌게한다.
// 총 가로수의 개수에서 원래 심어져있던 나무의 수를 빼서 출력한다.
// 최대공약수를 구하는 방법은 유클리드 호제법을 이용.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr2485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		long[] street = new long[n];
		for(int x=0; x<n; x++)
			street[x] = Long.parseLong(br.readLine());
		// 정렬
		Arrays.sort(street);
		// 간격끼리 최대공약수 구하기
		long result = 0;									// 간격끼리의 최대공약수를 저장할 변수
		for(int x=0; x<n-1; x++) {
			long interval = street[x+1] - street[x];		// 가로수 사이의 간격
			result = gcd(interval, result); 				// 간격끼리의 최대공약수
		}
		// 출력
		long output = (street[n-1] - street[0])/result + 1;	// 간격의 수 + 1 = 총 가로수의 수
		output = output - street.length;					// 총 가로수의 수 - 원래 심어져있던 가로수의 수
		System.out.print(output);
	}

	// 최대공약수 구하기
	// c = a를 b로 나눈 나머지
	public static long gcd(long a, long b) {
		while(b != 0) { // c가 0이 될 때
			long c = a%b;
			a=b;
			b=c;
		}
		return a;
	}
}