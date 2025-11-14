// 백준 11931번
// n개의 수 주어지면 내림차순 정렬해 출력하기.
// 방법---------------------
// 첫 줄에 n이 주어지고
// 다음 줄부터 n줄에 걸쳐 수가 주어진다.
// 내림차순 정렬하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class pr11931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		Integer num[] = new Integer[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(br.readLine());
		// 정렬
		Arrays.sort(num, Collections.reverseOrder());
		// 출력
		for(int i=0; i<n; i++)
			sb.append(num[i]).append("\n");
		System.out.print(sb.toString().trim());
	}
}