// 백준 15735번
// N층의 정삼각형이 주어졌을때, 크고 작은 정삼각형의 개수가 몇개인지 출력하는 문제.
// N이 2일 경우 정답은 5이다.
// 방법---------------------
// 첫 줄에 정수 n이 주어짐.
// 정삼각형, 뒤집힌 정삼각형 나눠서 규칙 찾기.
// 정삼각형 개수는 1부터 1, 1+2, 1+2+3, ... ~ , 1+ ... + n의 합
// 뒤집힌 정삼각형 개수는 1, 1+2+3 처럼 n-1층까지 홀수부분만.
// 오답------------------
// 뒤집힌 정삼각형 구하는 부분에서 for문
// for (int i = 1; i <= n - 1; i += 2)로 구현하면
// 1층부터 시작하는데 뒤집힌 정사각형 1층에 x

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr15735 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 삼각형 개수 구하기
		long output = 0;
		long[] tri = new long[n+1];
		for(int i=1; i<=n; i++)
			tri[i] = tri[i-1] + i;
		for(int i=1; i<=n; i++)
			output += tri[i];				// 정삼각형
		for(int i=n-1; i>0; i-=2)
            output += tri[i];				// 뒤집힌 정삼각형
		// 출력
		System.out.print(output);
	}
}