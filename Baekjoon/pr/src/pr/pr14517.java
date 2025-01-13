// 백준 23304번
// 문자열이 주어졌을 때, 팰린드롬이 되는 부분수열의 개수를 출력하는 문제.
// 주어진 문자열 S 의 부분수열 중 팰린드롬이 되는 부분수열의 개수를 10,007 로 나눈 나머지를 출력.
// 방법---------------------
// 첫 줄에 문자열 s를 입력 받음.
// dp 이용해 풀이.
// 부분 문자열 크기 늘려가며 팰린드롬 개수 세나가고
// 전체에 대한 팰린드롬 개수를 출력한다.
// 오답노트------------------
// dp[j][k] = (dp[j+1][k] + dp[j][k-1] - dp[j+1][k-1] + mod) % mod 에서
// dp[j+1][k] + dp[j][k-1] - dp[j+1][k-1] + mod 가 음수가 되는 경우가 있을 수 있으니까
// + mod 를 해주는 것.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr14517 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String input = br.readLine();
		// dp - dp[i][j] = 인덱스 i~j에서 팰린드롬의 개수
		int[][] dp = new int[1000][1000];
		int mod = 10_007;
		for(int i=0; i<input.length(); i++)
			dp[i][i] = 1;																// 길이 1이면 무조건 팰린드롬
		for(int i=2; i<=input.length(); i++) {
			for(int j=0; j+i<=input.length(); j++) {
				int k = j + i - 1;														// 끝 인덱스 저장할 변수 k
				if(input.charAt(j)==input.charAt(k))
					dp[j][k] = (dp[j+1][k] + dp[j][k-1] + 1) % mod;						// 새로운 팰린드롬 +1
				else
					dp[j][k] = (dp[j+1][k] + dp[j][k-1] - dp[j+1][k-1] + mod) % mod;	// 중복 빼주기
			}
		}
		// 출력
		System.out.print(dp[0][input.length()-1]);
	}
}