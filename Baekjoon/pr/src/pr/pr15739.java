// 백준 15739번
// 행렬을 입력 받고 매직스퀘어인지 출력하는 문제
// 방법---------------------
// 첫째 줄에 n을 입력 받고
// 다음 줄부터 n줄에 걸쳐 행렬을 입력 받는다.
// for문을 돌며 행의 합, 열의 합, 2개의 대각선의 수열의 합이 n × (n^2 + 1) / 2 인지 확인
// TRUE or FALSE 출력.
// 주의! - 숫자가 중복으로 들어오는지도 체크해야함(문제에서 숫자 중복x라고 했음)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr15739 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] input = new int[n][n];
		boolean[] check = new boolean[n*n+1];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				// 숫자 중복 체크
				if(input[i][j]<1 || input[i][j]>n*n || check[input[i][j]]) {
					System.out.print("FALSE");
					return;
				}
				check[input[i][j]] = true;
			}
		}
		// 판정
		int magic = n * (n*n + 1) / 2;
		int sum1 = 0, sum2 = 0;
		for(int i=0; i<n; i++) {
			long sum3 = 0, sum4 = 0;
			for(int j=0; j<n; j++) {
				sum3 += input[i][j];
				sum4 += input[j][i];
			}
			// 행열 합 확인
			if(sum3!=magic || sum4!=magic) {
				System.out.print("FALSE");
				return;
			}
			// 대각선 계산
			sum1 += input[i][i];
			sum2 += input[i][n-i-1];
		}
		// 대각선 합 확인
		if(sum1!=magic || sum2!=magic)
			System.out.print("FALSE");
		else
			System.out.print("TRUE");
	}
}