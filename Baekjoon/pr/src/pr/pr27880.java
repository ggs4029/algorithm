// 백준 27880번
// 입력을 받고 깊이를 단순히 계산해 출력하는 문제
// 방법---------------------
// 매줄마다 에스컬레이터인지 계단인지와 몇 계단인지를 한 줄에 입력 받는다.
// 플로어가 총 4라인이므로 4줄 입력 받음.
// 계산 후 깊이 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr27880 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int sum = 0;
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("Es")) {					// 에스컬레이터
				sum += Integer.parseInt(st.nextToken()) * 21;
			}
			else {												// 계단
				sum += Integer.parseInt(st.nextToken()) * 17;
			}
		}
		//출력
		System.out.print(sum);
	}
}