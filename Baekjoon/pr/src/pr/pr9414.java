// 백준 9414번
// 땅을 살건데, 땅 i의 현재 땅값이 Li인 경우, t년이 지난 후 땅값은 2×(Li)^t 가 됨.
// 일년에 땅을 하나만 살 수 있을 때 모든 땅을 구입하는데 드는 비용의 최솟값을 구하는 문제.
// 구입하려는 땅의 현재 가격은 문제에서 주어짐.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 t를 입력 받음.
// 각 테스트 케이스는 땅값 Li가 매 줄 주어지며 0이 들어오면 입력이 끝남.
// Li들 입력 받고 내림차순 정렬해서 가격이 비싼 땅부터 매입한다.
// 그랬을 때의 값을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class pr9414 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			ArrayList<Integer> ddang = new ArrayList<>();
			// 입력
			while(true) {
				int l = Integer.parseInt(br.readLine());
				if(l == 0)
					break;
				ddang.add(l);
			}
			// 정렬
			Collections.sort(ddang, Collections.reverseOrder());
			// 구입 최솟값 구하기
			long output = 0;
			for(int j=0; j<ddang.size(); j++) {
				output += 2 * (Math.pow(ddang.get(j), j+1));
				if(output > 5_000_000)
					break;
			}
			if(output > 5_000_000)
				sb.append("Too expensive").append("\n");
			else
				sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}