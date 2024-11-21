// 백준 11645번
// Alice가 방문한 도시들의 목록을 보고, 그녀가 적어도 한 번 방문한 다른 도시들의 개수를 구하는 문제.
// 방법---------------------
// 첫째 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스마다 첫 번째 줄에는 Alice가 지금까지 방문한 도시의 수 n(1 ≤ n ≤ 100)이 주어짐.
// 그 후 n줄에 걸쳐 도시 이름들을 입력 받음.
// 해시셋을 이용해서 중복된 도시 이름이 아닌 경우만 output++해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class pr11645 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			Set<String> city = new HashSet<>();
			int output = 0;
			for(int j=0; j<n; j++) {
				String input = br.readLine();
				if(!city.contains(input)) {
					city.add(input);
					output++;
				}
			}
			// 출력
			System.out.println(output);
		}
	}
}