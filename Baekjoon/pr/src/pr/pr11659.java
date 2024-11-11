// 백준 11659번
// 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 문제.
// 방법---------------------
// 첫 줄에 n과 구해야 하는 횟수 m이 주어짐.
// 둘째 줄부터는 m줄에 걸쳐 i와 j가 주어진다.
// for문 사용해 구간합 구해 출력.
// 시간 초과 주의! - 입력 처리 할때 주의 ( 배열 두번 만지지 않도록)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		long[] num = new long[n+1];
		String[] input2 = br.readLine().split(" ");
		for(int i=1; i<=n; i++)
			num[i] = num[i-1]+ Integer.parseInt(input2[i-1]);
		for(int x=0; x<m; x++) {
			String[] input3 = br.readLine().split(" ");
			int i = Integer.parseInt(input3[0]);
			int j = Integer.parseInt(input3[1]);
			// 구간합 구하기
			sb.append(num[j]-num[i-1]).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}