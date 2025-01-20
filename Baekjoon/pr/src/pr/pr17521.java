// 백준 17521번
// 코인의 n일 동안의 시세를 알 수 있다고 할 때,
// 초기 현금을 가지고 n일 날 보유하고 있는 모든 코인을 매도할 때 보유하게 될 최종 현금의 최댓값을 구하는 문제.
// 방법---------------------
// 첫 줄에 요일 수 n과 초기 자금 w를 입력 받음.
// 다음 줄부터 n줄에 걸쳐 그 날의 바이트 코인 가격을 입력 받는다.
// 어제보다 오늘 더 비싸면 어제 사고 오늘 판걸로 하는 식으로 돈 계산해서 최댓값 출력.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr17521 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		long[] day = new long[n];
		for(int i=0; i<n; i++)
			day[i] = Long.parseLong(br.readLine());
		// 최댓값 구하기
		long output = w;
		for(int i=1; i<n; i++) {
			if(day[i] > day[i-1]) {						// 어제보다 비싸면
				long tmp = (output / day[i-1]);			// 비트코인 개수
				output += tmp * (day[i] - day[i-1]);	// 개수 * 가격차이
			}
		}
		// 출력
		System.out.print(output);
	}
}