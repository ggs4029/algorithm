// 백준 17264번
// 형동이가 아이언을 탈출할 수 있을지 구하는 문제.
// 게임 규칙은 문제 참고.
// 방법---------------------
// 첫 줄에 총 게임 횟수 n과 해킹을 통해 얻은 플레이어 정보 수 p가 주어짐.
// 둘째 줄에는 이긴 경우 획득 점수 w와 졌을 때 떨어지는 점수 l, 그리고 IRON 티어에서 벗어나기 위한 점수 g가 주어짐.
// 그 다음 줄부터 p줄에 걸쳐 플레이어의 이름과 무조건 이길 수 있는 경우 W, 무조건 지는 경우 L이라는 단어가 플레이어 이름과 주어진다.
// 그 다음 n개의 줄에 같이 게임을 하는 플레이어의 이름이 나옴.
// 해시맵 사용해 만나면 이기는지 지는지 저장 해놓고 사용.
// 입력 받은거 탐색하며 아이언 탈출이 가능한지 구하고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class pr17264 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		Map<String, String> m = new HashMap<>();
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			m.put(st.nextToken(), st.nextToken());
		}
		// 아이언 탈출 가능 여부 구하기
		int tmp = 0;
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			if(m.containsKey(input)) {					// 정보 있는 애
				if(m.get(input).equals("W"))			// 이기는 애면
					tmp += w;
				else									// 지는 애면
					tmp -= l;
			}
			else										// 정보 없는 애
				tmp -= l;
			if(tmp<0)
				tmp = 0;
			if(tmp>=g) {
				System.out.print("I AM NOT IRONMAN!!");
				return;
			}
		}
		// 출력
		System.out.print("I AM IRONMAN!!");
	}
}