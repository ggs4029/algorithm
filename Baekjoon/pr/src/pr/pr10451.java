// 백준 10451번
// 키로거를 설치해서 비밀번호 창에 입력한 글자를 얻어냈음.
// 비밀번호 창에서 입력한 키가 주어졌을 때, 강산이의 비밀번호를 알아내는 프로그램을 작성.
// 키보드로 입력한 키는 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표.
// 방법---------------------
// 첫째 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스에 대해 입력이 두 줄 주어지는데,
// 첫줄은 순열의 크기 n이고 두번째 줄은 순열이 주어짐.
// visited배열로 그래프 탐색해가며 사이클 개수 찾고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr10451 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] num = new int[n+1];
			for(int j=1; j<=n; j++)
				num[j] = Integer.parseInt(input[j-1]);
			// 사이클 찾기
			boolean[] visited = new boolean[n+1];
			int output = 0;
			for(int j=1; j<=n; j++) {
				if (!visited[j]) {							// 방문 안했으면(새로운 사이클)
					output++;
					int tmp = j;
					while (!visited[tmp]) {					// 사이클 순회
						visited[tmp] = true;
						tmp = num[tmp];
					}
				}
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
}