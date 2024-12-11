// 백준 9251번
// 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제.
// 방법---------------------
// 한 줄씩 두 문자열이 입력으로 주어진다.
// dp이용해 lcs 구하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();
        Integer[][] dp = new Integer[input1.length + 1][input2.length + 1]; // dp 크기 1 증가시킴
        // dp
        for(int i=0; i<=input1.length; i++) {
            for(int j=0; j<=input2.length; j++)
                dp[i][j] = 0;
        }
        for(int i=0; i<input1.length; i++) {
            for(int j=0; j<input2.length; j++) {
                if(input1[i] == input2[j])
                    dp[i+1][j+1] = dp[i][j] + 1;
                else
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }

        // 출력
        System.out.print(dp[input1.length][input2.length]);
    }
}