// 백준 23304번
// 본문에 주어진 문제에 대해 답을 구해야함.
// 처음 모은 코코넛이 N개였고, 위의 규칙대로 K명의 사람들이 코코넛을 다들 나누어 가지는 데 성공했다면
// 이때 K는 최대 몇이 될 수 있는지 구하는 문제.
// 방법---------------------
// 각 테스트 케이스의 입력은 한 줄이고 코코넛의 개수 n을 입력 받음.
// -1을 입력 받을 때까지 계속 테스트 케이스를 받는다.
// 조건에 맞게 순회하며 max인 k값 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			if(n == -1)
				break;
			// 최대 k명 구하기
			int k = 0;
			for(int i=2; ; i++) {
				long tmp = 1;
				for(int j=0; j<i; j++) {
					tmp *= i;
					if(tmp > n)
						break;
				}
				if(tmp-i+1 > n)
					break;
				boolean tmp2 = true;
				int coconut = n;
				for(int j=0; j<i; j++) {
					coconut--;
					if(coconut%i == 0)										// 등분 가능하면
						coconut = (coconut * (i-1)) / i;
					else {
						tmp2 = false;
						break;
					}
				}
				if(tmp2 && coconut%i==0)
					k = i;
			}
			if(k < 2)
				sb.append(n + " coconuts, no solution").append("\n");
				else
					sb.append(n + " coconuts, " + k + " people and 1 monkey").append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}