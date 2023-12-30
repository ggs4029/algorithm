// 백준 7785번
// 회사에 있는 사람
// 방법----------
// 로그의 수 n을 입력 받고
// n개의 로그를 입력 받는다. (출퇴근)
// Hashmap을 활용해 이름과 출퇴근을 관리.
// enter인지 leave인지 확인하지 않아도
// 이미 이름이 있는 경우는 leave이므로 map에서 삭제한다.
// 키값만 정렬 후 반대로 출력 (역순으로 출력하라 하였으므로)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class pr7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		String name;								// 이름
		String work;								// 출근, 퇴근
		Map<String, String> map = new HashMap<>();
		for(int x=0; x<n; x++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			work = st.nextToken();
			// 출퇴근
			if(!map.containsKey(name)) {			// 이름이 안에 없으면
				map.put(name, work);				// put
			}
			else {									// 이름이 안에 있으면
				map.remove(name);					// remove
			}
		}
		// 정렬
		String[] output = new String[map.keySet().size()];
		int i = 0;
		for(String x : map.keySet()) {
			output[i] = x;
			i++;
		}
		Arrays.sort(output);
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int x=output.length-1; x>=0; x--) {
			sb.append(output[x]).append('\n');
		}
		System.out.print(sb.toString());
	}
}