// 백준 26123번
// 매일 제일 높은 빌딩에 레이저를 쏴서 높이를 1 낮출거임.
// 모든 빌딩의 높이가 0이 될 때까지 레이저를 쏘려하고
// 제일 높은 빌딩이 여러개면 그 빌딩들 다 쏠 때, d일이 주어지면 d일 동안 레이저 몇 번 쐈는지 구하는 문제.
// 방법---------------------
// 첫 줄에 건물 개수 n과 계획을 수행한 날의 수 d를 입력 받음.
// 제일 높은 빌딩이 레이저를 맞기 시작해서 d일 동안 맞을거고
// 나머지 빌딩들은 높이 - (제일 높은 빌딩의 d일 후의 높이) 만큼 레이저 맞을거니까
// 빌딩 높이 순회하면서 답 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr26123 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(num);
		// 레이저 쏘기
		long output = 0;
		int max = num[n-1];							// 제일 높은 빌딩 높이
		int tmp = max - d;							// 제일 높은 빌딩이 d일 후에 높이
		if(tmp < 0)									// 제일 높은 빌딩이 d일 후에 높이가 음수가 되면
			tmp = 0;
		for(int i=0; i<n; i++) {
			if(num[i] > tmp)
				output += num[i] - tmp;				// 나머지 빌딩들은 차 만큼 레이저 맞음
		}
		// 출력
		System.out.print(output);
	}
}