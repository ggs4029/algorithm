// 백준 15652번
// N개의 서로 다른 종류의 사탕이 주어짐.
// 각 사탕 종류는 사탕의 개수 k와 사탕의 칼로리 c로 구성.
// 이 사탕들을 두 그룹으로 나누어 각 그룹의 칼로리 합의 차이를 최소화하는 것이 목표.
// 방법---------------------
// 첫째 줄에 사탕의 종류 n이 주어짐.
// 그 다음 n줄에 걸쳐 각 사탕의 개수 k와 칼로리 c가 주어진다.
// dp이용해

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr6838 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        int n = Integer.parseInt(br.readLine());
        int tmp = 0;
        int[][] candy = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            candy[i][0] = Integer.parseInt(input[0]);
            candy[i][1] = Integer.parseInt(input[1]);
            tmp += candy[i][0] * candy[i][1];
        }
        // dp
        boolean[] dp = new boolean[tmp+1];
        dp[0] = true;
        for(int i=0; i<n; i++) {
            int num = candy[i][0];											// 사탕 개수
            int cal = candy[i][1];											// 사탕 칼로리
            for(int j=tmp; j>=cal; j--) {									// 사탕1개 칼로리 이상이면 돌림
                for(int k=1; k<=num && j-cal*k>=0; k++) {					//
                    if(dp[j-cal*k])											//
                        dp[j] = true;
                }
            }
        }
        // 최소 차이 구하기
        int total = tmp;
        int output = Integer.MAX_VALUE;
        // 가능한 칼로리 합 중 total/2에 가장 가까운 값을 찾아 최소 차이 계산
        for(int i=0; i<=tmp/2; i++) {
            if(dp[i])
                output = Math.min(output, Math.abs(total - 2 * i));
        }
        // 출력
        System.out.print(output);
    }
}
