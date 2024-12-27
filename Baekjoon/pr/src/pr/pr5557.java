// 백준 5557번
// 숫자들 입력 받고 숫자들 사이에 + or - 넣어서 등식 만들거임. (마지막 두 숫자사이엔 = 넣을거)
// 아직 학교에서 음수를 배우지 않았고, 20을 넘는 수는 모른다.
// 따라서, 왼쪽부터 계산할 때, 중간에 나오는 수가 모두 0 이상 20 이하이어야 한다.
// 예를 들어, "8+3+2-4-8-7+2+4+0+8=8"은 올바른 등식이지만, 8+3+2-4-8-7이 음수이기 때문에, 만들 수 없는 등식.
// 숫자가 주어졌을 때, 만들 수 있는 올바른 등식의 수를 구하는 문제.
// 방법---------------------
// 첫 줄에 숫자 개수 n이 주어짐.
// 둘째 줄에 숫자 n개가 주어진다.
// dp이용해 해결.
// dp[i][j] -->  i번째까지 계산했을 때 등식의 값이 j인 경우의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr5557 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] num = new int[n+1];
		for(int i=1; i<=n;  i++)
			num[i] = Integer.parseInt(input[i-1]);
		// dp
		long[][] dp = new long[n+1][20+1];
		dp[1][num[1]] = 1;									// 첫 숫자만 있으면 만들수 있는 개수는 당연히 1
		for(int i=2; i<n; i++) {
			for(int j=0; j<20+1; j++) {
				if(dp[i-1][j]!=0) {							// 전에 한 계산이 j인 경우가 존재했으면
					if(j+num[i]<=20)
						dp[i][j+num[i]] += dp[i-1][j];		// 더하기
					if(j-num[i]>=0)
						dp[i][j-num[i]] += dp[i-1][j];		// 빼기
				}
			}
		}
		// 출력
		System.out.print(dp[n-1][num[n]]);
	}
}