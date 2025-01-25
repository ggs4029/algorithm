// 백준 115824428번
// 메뉴가 아주 다양한 이 음식점은 모든 메뉴의 스코빌 지수를 명시한 메뉴판을 제공한다.
// 주헌이의 목표는 이 음식점의 모든 음식 조합을 먹어보는 것이다.
// 하지만 주헌이는 까다로워서 한 번 먹어본 조합은 다시 먹지 않는다.
// 이 음식점의 모든 조합을 먹어 볼 때 주헌이가 즐길 수 있는 주헌고통지수의 합을 구해보는 문제.
// 음식을 먹고 느낄수 있는 스코빌 지수의 (최댓값 - 최솟값)을 주헌고통지수라고 정의한다.
// 방법---------------------
// 첫 줄에 메뉴 개수 n을 입력 받음.
// 다음 줄에 n개의 메뉴의 스코빌 지수를 입력 받는다.
// 모든 조합 구하기 -> 모든 조합의 최댓값 - 모든 조합의 최솟값
// 본인이 i번째 요소일 때
// 모든 조합의 최댓값 = 자기자신 제외한 2^(i-1)
// 모든 조합의 최솟값 = 자기자신 빼고 2^(n-i)
// Math.pow -> 시간 초과, 제곱 계산 메소드로 따로 구현

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr15824 {
	public static final int tmp = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(num);
		// 모든 조합의 고통지수 합 구하기
		long output = 0;
		for(int i=1; i<=n; i++) {
			output += ((mul(2, i-1) - mul(2, n-i)) * num[i]);
			output %= tmp;
		}
		// 출력
		System.out.print(output);
	}

	// 메소드를 이용한 제곱 계산 (x^y 계산)
	public static long mul(int x, int y) {
		if(y == 0)
			return 1;
		long half = mul(x, y/2);					// 재귀
		if(y%2 == 1)								// 홀수번 거듭제곱이면
			return half * half * x % tmp;
		else										// 짝수번 거듭제곱이면
			return half * half % tmp;
	}
}