// 백준 10942번
// 먼저, 홍준이는 자연수 N개를 칠판에 적는다. 그 다음, 명우에게 질문을 총 M번 한다.
// 각 질문은 두 정수 S와 E(1 ≤ S ≤ E ≤ N)로 나타낼 수 있으며,
// S번째 수부터 E번째 까지 수가 팰린드롬을 이루는지를 물어보며,
// 명우는 각 질문에 대해 팰린드롬이다 또는 아니다를 말해야 한다.
// 자연수 N개와 질문 M개가 모두 주어졌을 때, 명우의 대답을 구하는 문제.
// 방법---------------------
// 첫 줄에 수열 크기 n을 입력 받음.
// 둘째 줄에 칠판에 적은 수 n개가 주어짐.
// 셋째 줄에 질문 수 m이 주어지고
// 그 다음 줄부터 m줄에 걸쳐 질문 s, e가 한줄에 주어진다.
// dp 이용해 풀이.
// 부분 문자열 크기 늘려가며 팰린드롬인지 검사하고
// s~e인 부분 문자열의 팰린드롬 여부들을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr10942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] board = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			board[i] = Integer.parseInt(st.nextToken());
		// dp - dp[i][j] = 인덱스 i~j에서 팰린드롬의 개수
		int[][] dp = new int[2000][2000];
		for(int i=0; i<n; i++)
			dp[i][i] = 1;										// 길이 1이면 무조건 팰린드롬
		for(int i=2; i<=n; i++) {
			for(int s=0; s+i-1<n; s++) {
				int e = s + i - 1;
				if(board[s]==board[e]) {						// 양 끝이 같고
					if(i==2)									// 길이 2면 팰린드롬
						dp[s][e] = 1;
					else										// 길이가 3 이상일때
						dp[s][e] = dp[s+1][e-1]; 				// 양 끝 뺀 문자열이 팰린드롬인 경우의 수와 같음
				}
				else											// 양 끝 다르면
					dp[s][e] = 0; 								// 팰린드롬 x
			}
		}
		// 입력2
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dp[s-1][e-1]).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}