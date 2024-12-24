// 백준 12865번
// dp식이 주어졌고, n과 dp[n]을 입력 받고
// dp[1] dp[2]를 구하는 문제.
// 방법---------------------
// 첫 줄에 할머니가 넘어온 날 d를 입력 받고 그 날 호랑이에게 준 떡의 개수 k를 입력 받음.
// 이중 for문 돌면서 완전 탐색으로 첫 날과 둘째 날의 떡의 개수를 구해서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int d = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		// 탐색
		for(int i=1; i<=k;  i++) {
			for(int j=i; j<=k;  j++) {
				int[] dduck = new int[d+1];
				dduck[1] = i; dduck[2] = j;
				for(int x=3; x<=d;  x++)
					dduck[x] = dduck[x-2] + dduck[x-1];
				if(dduck[d]==k) {
					// 출력
					System.out.println(i);
					System.out.print(j);
					return;
				}
			}
		}
	}
}