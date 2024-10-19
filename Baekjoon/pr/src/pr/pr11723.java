// 백준 11723번
// 공집합 s가 주어졌을 때 문제에서 주어진 연산을 수행하는 프로그램을 작성하는 문제
// 방법---------------------
// 첫 줄에 수행해야 하는 연산 수 m을 입력 받음.
// 다음 줄부터 m줄에 걸쳐 수행해야하는 연산이 주어짐.
// 주의! - 비트마스크를 사용해야 시간초과가 안걸림.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = 0;
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			String order = input[0];
			if(order.equals("all"))
				s = (1 << 21) - 1;
			else if(order.equals("empty"))
				s = 0;
			else {
				int x = Integer.parseInt(input[1]);
				if(order.equals("add"))
					s |= (1 << x);
				else if(order.equals("remove"))
					s &= ~(1 << x);
				else if(order.equals("check"))
					sb.append((s & (1 << x)) != 0 ? 1 : 0).append("\n");
				else
					s ^= (1 << x);
			}
		}
		// 출력
		System.out.println(sb.toString());
	}
}