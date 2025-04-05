// 백준 1980번
// 타워버거 불고기버거 두 종류가 있음.
// 타워버거 먹는데 n분 불고기버거 먹는데 m분 걸림.
// 햄버거를 먹지 않는 시간은 콜라를 마심.
// t분 동안 햄버거를 최대한 많이 먹으려 할 때 햄버거를 가장 많이 먹을 수 있는 경우를 찾아서
// 먹은 햄버거의 수와 최소로 콜라를 마신 시간을 출력.
// 방법---------------------
// 첫 줄에 n과 m, t가 주어짐.
// 타워버거 먼저 계산했을 때랑 불고기버거 먼저 시간계산했을 때랑 둘로 나누어서
// 최대 햄버거 수랑 최소 콜라 마신 시간 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1980 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		// 최대 햄버거 수와 최소 콜라 마신 시간 구하기
		int sum = 0;
		int time = t;
		for(int i=0; i<=t/n; i++) {							// 타워버거
			int tmp = t - i * n;							// 남은 시간
			int j = tmp / m;
			int time2 = tmp - j * m;						// 불고기버거까지 다 먹고 남은 시간
			int tmp2 = i + j;								// 햄버거 개수
			if(time>time2 || (time==time2 && tmp2>sum)) {	// 햄버거 개수 최대값 갱신
				sum = tmp2;
				time = time2;
			}
		}
		for(int i=0; i<=t/m; i++) {							// 불고기버거
			int tmp = t - i * m;							// 남은 시간
			int y = tmp / n;
			int time2 = tmp - y * n;						// 타워버거까지 다 먹고 남은 시간
			int tmp2 = i + y;								// 햄버거 개수
			if(time>time2 || (time==time2 && tmp2>sum)) {	// 햄버거 개수 최대값 갱신
				sum = tmp2;
				time = time2;
			}
		}
		// 출력
		System.out.print(sum + " " + time);
	}
}