// 백준 15688번
// n개의 수가 주어지면 비내림차순으로 정렬하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 다음줄부터 n줄에 걸쳐 정수들이 주어진다.
// 그냥 정렬하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr15688 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		int num[] = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(br.readLine());
		// 정렬
		Arrays.sort(num);
		// 출력
		for(int i=0; i<n; i++)
			sb.append(num[i]).append("\n");
		System.out.print(sb.toString().trim());
	}
}