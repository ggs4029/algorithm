// 백준 11728번
// 정렬되어있는 두 배 열 a, b가 주어지면
// 두 배열을 합친 다음 정렬해서 출력하는 문제.
// 방법---------------------
// 첫 줄에 배열 a, b의 크기 n, m을 입력 받음.
// 둘째 줄에는 배열 a의 내용이, 막줄에는 배열 b의 내용이 주어짐.
// 두 배열 한 배열에 입력 받고 함수 이용해 정렬 후 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] num = new int[n+m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++)
			num[i+n] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(num);
		// 출력
		for(int i : num)
			sb.append(i + " ");
		System.out.print(sb.toString().trim());
	}
}