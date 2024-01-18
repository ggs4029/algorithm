// 백준 26069번
// 붙임성 좋은 총총이
// 댄스를 추는 사람의 수를 구하는 문제
// 방법------------------------
// 사람들이 만난 기록의 수 n을 입력 받고
// 그 다음줄부터 n줄에 걸쳐 만난 기록들을 입력 받는다.
// 디폴트로 해시맵에 value값은 0으로 add하되,
// if문을 이용해 총총이가 포함된 줄이면
// value값을 1로 add한다. (1이면 댄스중)
// 그다음에 else if로 총총이랑 접촉한적 있는지 검사한다.
// for문을 이용해 map을 돌며 댄스 중인 사람 수를 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class pr26069 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 입력
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();

		for(int x=0; x<n; x++) {
			st = new StringTokenizer(br.readLine());
			String input1 = st.nextToken();
			String input2 = st.nextToken();
			// 없는 사람이면 일단 추가
			if(!map.containsKey(input1))
				map.put(input1, 0);
			if(!map.containsKey(input2))
				map.put(input2, 0);
			// 이 줄에 총총이가 있는지 검사
			if(input1.equals("ChongChong") || input2.equals("ChongChong")) {
				map.put(input1, 1);
				map.put(input2, 1);

			}
			// 총총이랑 접촉한적 있는지 검사
			else if(map.get(input1)==1 || map.get(input2)==1) {
				map.put(input1, 1);
				map.put(input2, 1);

			}
		}
		// 댄스 중인 사람 수 구하기
		int sum = 0;
		for(String key : map.keySet()) {
			if(map.get(key)==1)
				sum++;
		}
		// 출력
		System.out.print(sum);
	}
}