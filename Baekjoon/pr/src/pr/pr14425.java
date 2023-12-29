// 백준 14425번
// 문자열 집합
// 입력으로 주어지는 M개의 문자열 중에서
// N개의 문자열로 이루어진 집합 S에
// 포함되어 있는 것이 총 몇 개인지 구하는 프로그램
// 방법-----------------------------
// n,m을 입력 받고 n+m개의 문자열들을 입력 받는다.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] S = new String[n];					// 집합 S
		for(int x=0; x<n; x++) {
			S[x] = br.readLine();
		}
		// 집합 순회
		int sum = 0;
		for(int x=0; x<m; x++) {
			String input = br.readLine();
			for(int y=0; y<n; y++) {
				if(S[y].equals(input)) {			// 문자열이 집합 S에 포함되어 있으면
					sum++;							// sum+1
				}
			}
		}
		// 출력
		System.out.print(sum);
	}
}