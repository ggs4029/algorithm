// 백준 11660번
// N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 문제.
// 방법---------------------
// 첫 줄에 표의 크기 n과 합을 구해야 하는 횟수 m이 주어짐.
// 둘째 줄부터 n줄에 걸쳐 표에 채워져있는 수가 주어짐.
// 그 다음줄부터 m줄에 걸쳐 네개의 정수 x1, y1, x2, y2가 주어짐.
// 2차원 배열 이용해 구간합 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		long[][] num = new long[n+1][n+1];
		for(int x=1; x<=n; x++) {
			String[] input2 = br.readLine().split(" ");
			for(int y=1; y<=n; y++)
				num[x][y] = num[x-1][y] + num[x][y-1] - num[x-1][y-1] + Integer.parseInt(input2[y-1]);
		}
		// 구간합 구하기
		for(int x=0; x<m; x++) {
			String[] input3 = br.readLine().split(" ");
			int x1 = Integer.parseInt(input3[0]);
			int y1 = Integer.parseInt(input3[1]);
			int x2 = Integer.parseInt(input3[2]);
			int y2 = Integer.parseInt(input3[3]);
			long output = num[x2][y2] - num[x1-1][y2] - num[x2][y1-1] + num[x1-1][y1-1];
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}