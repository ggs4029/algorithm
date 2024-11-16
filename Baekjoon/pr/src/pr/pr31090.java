// 백준 31090번
// 내년의 연도인 2024가 올해 연도의 끝 두 자리인 23으로 나누어 떨어진다!
// 다음에도 이런 연도가 오려면 6년 뒤인 2029/2030년이 되어야 한다.
// 양의 정수 N이 주어진다. N년과 N+1년이 이러한 조건을 만족하는 관계를 만족하는지 구하는 문제.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t가 입력으로 주어짐.
// 다음 줄부터 t줄에 걸쳐 n이 주어진다.
// n+1이 n의 끝 두자리로 나누어지는지 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31090 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int tmp = n%100;
			if(tmp==0) {
				sb.append("Bye").append("\n");
				continue;
			}
			if((n+1)%tmp==0)
				sb.append("Good").append("\n");
			else
				sb.append("Bye").append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}