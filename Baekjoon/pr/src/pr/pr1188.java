// 백준 1188번
// 소시지의 수와 평론가의 수가 주어졌을 때
// 모든 평론가에게 같은 양의 소시지를 주기 위해 필요한 칼질의 수를 구하는 문제
// 방법---------------------
// 첫 줄에 소시지의 수 n과 평론가의 수 m이 주어짐.
// m(평론가의 수)/ gcd(n, m) = 소시지 하나를 몇 조각으로 나눠야하는지 그 수
// 소시지 하나를 자를 횟수 = 소시지 하나로 만들 조각 수 - 1
// 소시지 하나 자를 횟수 = m / gcd(n, m) - 1
// 모든 소시지에 칼질해야함으로 gcd만큼 여기에 곱해줌
// 값을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1188 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		//출력
		System.out.print((m/gcd(n,m)-1) * gcd(n,m));
	}

	// 최대공약수 구하기 - 유클리드 호제법
	public static int gcd(int a, int b) {
		while(b>0) {
			int tmp = a;
			a = b;
			b = tmp%b;
		}
		return a;
	}
}