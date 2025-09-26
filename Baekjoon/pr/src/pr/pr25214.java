// 백준 25214번
// 빈배열 a의 맨 뒤에 정수를 n번 추가하려함.
// 수를 추가할 때마다 aj - ai의 최댓값을 구하는 문제.
// ai는 i번째로 추가된 정수를 의미.
// 방법---------------------
// 첫 줄에 추가하려는 정수의 개수 n이 주어짐.
// 다음 줄에는 추가되는 n개의 정수가 한줄에 주어진다.
// 순회하면서 최솟값이 갱신되면 그대로 output값 출력
// 아닌 경우는 단순하게 원래 output값과 현재의 aj - ai값을 비교해 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr25214 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		int output = 0;
		int min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(min > tmp)											// ai의 최솟값이 갱신되면
				min = tmp;
			else
				output = Math.max(output, tmp - min);				// 지금 aj - ai 값과 비교
			sb.append(output).append(" ");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}