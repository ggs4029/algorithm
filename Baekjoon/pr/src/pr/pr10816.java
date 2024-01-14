// 백준 10816번
// 숫자 카드 2
// 숫자 카드 n개를 가지고
// 정수 m개가 주어지면 그 카드를 몇 장 가지고 있는지 구하는 문제
// 방법-----------------------
// n을 입력 받고 다음줄에 n개의 정수를 입력 받고
// 해시맵에 add 한다. (이미 있는 key면 value만 +1)
// m을 입력 받고 다음줄에 m개의 정수를 입력 받고
// 그 값을 key로 검색해 value를 한 줄로 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class pr10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 입력
		Map<Integer, Integer> map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int x=0; x<n; x++) {
			int n_input = Integer.parseInt(st.nextToken());
			if(map.containsKey(n_input)) {					// 이미 있는 key면
				map.put(n_input, map.get(n_input)+1);		// value만 +1
			}
			else {											// 없는 key면
				map.put(n_input, 1);						// value 1로 put
			}
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int x=0; x<m; x++) {
			int m_input = Integer.parseInt(st.nextToken());
			if(!map.containsKey(m_input))					// 없는 key면
				sb.append(0).append(' ');					// 0으로 출력
			else
				sb.append(map.get(m_input)).append(' ');
		}
		// 출력
		System.out.print(sb.toString());
	}
}