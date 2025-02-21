// 백준 5623번
// 양의 정수 N개로 이루어진 수열 A가 있다.
// 상근이는 수열 A의 모든 두 수의 합을 알고 있을 때
// 수열 A를 구하는 문제.
// 방법---------------------
// 첫 줄에 수열 크기 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 작거나 같은 양의 정수가 n개 주어짐. (두 수의 합들)
// 주어진 입력으로 수열 a복원하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr5623 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] s = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				s[i][j] = Integer.parseInt(st.nextToken());
		}
		// a 수열 구하기
		int[] a = new int[n];
		if(n == 2) {
			a[0] = s[0][1] / 2;
			a[1] = s[0][1] / 2;
		}
		else {											// n이 3이상
			a[0] = (s[0][1] + s[0][2] - s[1][2]) / 2;
			for(int i=1; i<n; i++)
				a[i] = s[0][i] - a[0];
		}
		// 수열 출력
		for(int i=0; i<n; i++)
			sb.append(a[i]).append(" ");
		System.out.println(sb.toString().trim());
	}
}