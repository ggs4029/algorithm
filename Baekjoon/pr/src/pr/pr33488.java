// 백준 33488번
// 길이가 n인 아름다운 수열이 존재하면 YES와 원소들을 출력하고
// 존재하지 않으면 NO
// 아름다운 수열이 무엇인지는 문제 참조.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 주어지고
// 다음 줄부터 t줄에 걸쳐 n이 주어진다.
// 걍 1~n 순서대로 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr33488 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			sb.append("YES").append("\n");
			for(int j=1; j<=n; j++)
				sb.append(j).append(" ");
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}