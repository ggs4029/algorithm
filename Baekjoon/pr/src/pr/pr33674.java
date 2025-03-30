// 백준 CPC(2025_03_29) A1번
// n개 점에 d일 동안 별이 떨어지는데 i번 점에는 매일 si개의 별이 떨어짐.
// 쌓인 별의 개수가 k개를 초과시 폭발.
// 밤이 되기 전 낮에 청소 작업을 하면 모든 점에 쌓인 별이 0개가됨.
// d일 동안 떨어진 별이 폭발하지 않게 관리해야 할 때, 별이 폭발하지 않도록 하는 최소 청소 횟수를 구하는 문제.
// 방법---------------------
// 첫 줄에 n, d, k를 입력 받고
// 다음 줄에 s1 ~ sn을 입력 받음.
// 제일 빨리 초과하는 점의 버틸수있는 날을 구하고
// d로 나눠서 출력.
// 오답1--------------------
// d/day가 정수로 딱 나눠떨어지면
// 마지막에는 청소할 필요가 없음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr33674 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());					// n개의 점에
		int d = Integer.parseInt(st.nextToken());					// d일 동안 별이 떨어지고
		int k = Integer.parseInt(st.nextToken());					// k개 초과시 폭발
		int[] star = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			star[i] = Integer.parseInt(st.nextToken());
		// 제일 빨리 초과하는 점이 버틸수 있는 날짜 구하기
		int day = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			int tmp = k / star[i];
			day = Math.min(day, tmp);
		}
		// 출력
		if(day >= d)
			System.out.print(0);
		else
			System.out.print((int)Math.ceil((double)d / day) - 1);	// 올림 계산
	}
}