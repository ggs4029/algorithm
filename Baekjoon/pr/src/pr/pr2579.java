// 백준 2579번
// 계단 오르기
// 문제에서 주어진 규칙에 따라 계단을 올랐을 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 문제
// 방법---------------------
// 첫 줄에 계단의 개수 num을 입력 받음.
// 다음줄부터 num줄에 걸쳐 맨 아래 계단부터 점수를 입력 받음.
// dp로 구현해 점수의 최댓값을 계산.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int num = Integer.parseInt(br.readLine());
		int[] score = new int[num+1];
		for(int i=1; i<=num; i++)
			score[i] = Integer.parseInt(br.readLine());
		// dp이용해 연산 최솟값 찾기
		int[] dp = new int[num+1];
		// 초기값 설정
		dp[1] = score[1];
		if(num>1)
			dp[2] = score[1] + score[2];
		// dp 계산
		for(int i=3; i<=num; i++)
			// 두 계단 뛰어온 경우 or 한 계단 더 밟아온 경우
			dp[i] = Math.max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i]);
		// 출력
		System.out.print(dp[num]);
	}
}