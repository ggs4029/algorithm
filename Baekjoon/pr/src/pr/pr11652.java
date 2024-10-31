// 백준 11652번
// 숫자 카드 n장을 가지고 있고 카드에는 정수가 쓰여 있을 때, 가장 많이 가지고 있는 정수를 구하는 문제.
// 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력
// 방법---------------------
// 첫 줄에 가지고 있는 숫자 카드 개수 n을 입력 받고
// 다음 줄부터 n줄에 걸쳐 숫자들을 입력 받음.
// 해시맵을 사용해 저장.
// value순으로 먼저 내림차순 정렬 -> key순으로 오름차순 정렬 후 맨 앞을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pr11652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> card = new HashMap<>();
		for(int i=0; i<n; i++) {
			long input = Long.parseLong(br.readLine());
			if(card.containsKey(input)) {
				int tmp = card.get(input) + 1;
				card.put(input, tmp);
			}
			else
				card.put(input, 1);
		}
		// 정렬
		List<HashMap.Entry<Long, Integer>> sortCard = new ArrayList<>(card.entrySet());
		sortCard.sort((x, y) -> {
			if(x.getValue().equals(y.getValue()))							// value 같으면
				return Long.compare(x.getKey(), y.getKey());				// key기준 오름차순
			else															// 아니면
				return Integer.compare(y.getValue(), x.getValue());			// value기준 내림차순
		});
		// 출력
		System.out.print(sortCard.get(0).getKey()); 						// key값 출력

	}
}