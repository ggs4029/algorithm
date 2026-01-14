// 백준 9252번
// 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제.
// 방법---------------------
// 한 줄씩 두 문자열이 입력으로 주어진다.
// dp로 lcs 길이부터 구하고
// 맨 뒤에서부터 lcs 문자열 찾기.
// 오답노트1-----------------
// 뒤에서부터 찾았으니까 문자열 역순으로 쌓임.
// 역순으로 출력.
// 오답노트2-----------------
// lcs 길이 0이면 두번째 줄 출력하지 말라했으므로 출력 수정.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		char[] input1 = br.readLine().toCharArray();
		char[] input2 = br.readLine().toCharArray();
		int[][] dp = new int[input1.length+1][input2.length+1];
		// dp
		for(int i=1; i<=input1.length; i++) {
			for(int j=1; j<=input2.length; j++) {
				if(input1[i-1] == input2[j-1])
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		// lcs 길이와 문자열 구하기
		int lcs = dp[input1.length][input2.length];
		System.out.println(lcs);										// 출력1
		if(lcs > 0) {
			int len1 = input1.length;
			int len2 = input2.length;
			while(len1>0 && len2>0) {
				if(input1[len1-1] == input2[len2-1]) {					// 같으면 lcs
					sb.append(input1[len1-1]);
					len1--;
					len2--;
				}
				else if(dp[len1-1][len2] == dp[len1][len2])
					len1--;
				else
					len2--;
			}
			System.out.print(sb.reverse().toString());					// 출력2
		}
	}
}