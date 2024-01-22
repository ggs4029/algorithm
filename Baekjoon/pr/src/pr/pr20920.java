// 백준 20920번
// 영단어 암기는 괴로워
// 문제에서 주어진 조건에 따라 영단어 정렬하기
// 방법---------------------
// n과 m을 한줄에 입력 받고
// 다음줄부터 n줄에 걸쳐 단어들을 입력 받는다.
// 입력 받은 단어들 중 길이가 m이상인 단어들만 해시맵에 추가하고
// 중복으로 들어올때마다 value를 +1 해준다.
// 단어를 다 받았으면 문제에서 주어진 조건대로 정렬한다.
// 1. 자주 등장하는 순서대로
// 2. 단어의 길이가 길수록
// 3. 사전 순으로 앞에 있을수록
// 차례대로 if문으로 구현하고
// 정렬된 단어들을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class pr20920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		// n과 m 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 단어 입력
		Map<String, Integer> map = new HashMap<>();
		for(int x=0; x<n; x++) {
			String input = br.readLine();
			if(input.length()>=m) {								// 길이 m이상만 단어장에 추가
				if(map.containsKey(input)) {					// 이미 있는 단어면
					map.put(input, map.get(input)+1);			// value만 +1
				}
				else {											// 없는 단어면
					map.put(input, 1);							// value 1로 put
				}
			}
		}
		// 정렬
		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                // 자주 등장하는 단어 순서대로
                if(map.get(x) != map.get(y)) {
                	return map.get(y).compareTo(map.get(x));
                }
                // 단어의 길이가 길수록
                if(x.length() != y.length()) {
                	return y.length() - x.length();
                }
                // 사전 순으로 앞에 있을수록
                return x.compareTo(y);
            }
        });
		// 출력
		for(String s : list)
			sb.append(s).append('\n');
		System.out.print(sb.toString());
	}
}