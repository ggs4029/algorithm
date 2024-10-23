// 백준 26307번
// 문제를 푸는데 소요된 시간을 구하는문제
// 9시 시작
// 방법---------------------
// 첫 줄에 시간과 분을 입력 받음.
// 분으로 계산해 9시부터 몇분이 지났는지 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr26307 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int h = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		// 시간 계산
		int sum = 0;
		sum += (h-9) * 60;
		sum += m;
		// 출력
		System.out.print(sum);
	}
}