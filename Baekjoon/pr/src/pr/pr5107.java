// 백준 5107번
// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 문제.
// N개의 자연수 중에서 M개를 고른 수열.
// 방법---------------------
// 첫째 줄에 n과 m이 주어짐.
// dfs를 이용해 풀이.
// 선행이 돌고 돌아 나에게 온다 = 강연결 요소를 찾는 문제.
// 해시맵과 배열리스트 구현해 강연결 요소가 몇개 있는지 찾아 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class pr5107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 1;
		while(true) {
			// 입력
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			ArrayList<String> man = new ArrayList<>();			// 선행 베풀기에 참여한 사람
			HashMap<String, String> h = new HashMap<>();		// 마니또 선행 목록 저장 해시맵
			for(int i=0; i<n; i++) {
				String[] input = br.readLine().split(" ");
				man.add(input[0]);
				h.put(input[0], input[1]);
			}
			// 연결 고리 개수 구하기
			int output = 0;
			for(String s : man) {
				String target = h.get(s);						// 선행을 받는 사람
				while(true) {
					target = h.get(target);
					if(target==null) {							// 중복 방문이면
						break;
					}
					else if(target.equals(s)) {
						h.remove(target);						// 중복 방문 제외하기 위해 제거
						output++;
						break;
					}
				}
			}
			sb.append(count+" "+ output).append("\n");
			count++;
		}
		// 출력
		System.out.print(sb.toString());
	}
}