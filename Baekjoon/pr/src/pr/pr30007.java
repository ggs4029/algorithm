// 백준 30007번
// 라면을 제일 맛있게 먹을수 있는 물 양을 구하는 문제.
// 문제대로 입력 받고 공식대로 구해서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30007 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			// 물 양 구하기
			long w = a * (x-1) + b;
			sb.append(w).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}