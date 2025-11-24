// 백준 15651번
// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 문제.
// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열.
// 같은 수를 여러 번 골라도 됨.
// 수열은 사전 순으로 증가하는 순서로 출력.
// 방법---------------------
// 첫째 줄에 n과 m이 주어짐.
// 중복을 고려할 필요가 업ㅅ으므로 기본적인 dfs 코드에서
// visited부분을 싹다 도려내서 중복 체크 하지말아야함.
// 수열 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15651 {
	public static int n, m;
	public static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[m];
		// dfs
		dfs(0, sb);
		// 출력
		System.out.print(sb.toString().trim());
	}

	// dfs
	private static void dfs(int depth, StringBuilder sb) {
		if(depth == m) {
			for(int i : num)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
			num[depth] = i + 1;
			dfs(depth + 1, sb);							// 깊이+1 하고 제호출
		}
	}
}