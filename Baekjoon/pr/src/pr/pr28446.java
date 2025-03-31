// 백준 28446번
// 문제에서 주어지는 두가지 요청에 따라 볼링공 관리하는 문제.
// 방법---------------------
// 첫 줄에 요쳥의 개수 m을 입력 받음.
// 다음 줄부터 m줄에 따라 요청들을 한 줄에 입력 받음.
// 해시맵으로 저장하고 요청에 따라 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class pr28446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int m = Integer.parseInt(br.readLine());
		// 요청 처리
		HashMap<Integer, Integer> h = new HashMap<>();
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			if(input == 1) {									// x번 사물함에 w무게 볼링공 넣기
				int x = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				h.put(w, x);
			}
			else {												// w무게 가진 볼링공이 있는 사물함 번호 출력
				int w = Integer.parseInt(st.nextToken());
				sb.append(h.get(w)).append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}