// 백준 29718번
// 브실브실 학교 축제에서 연속된 a열 중 박수 횟수가 제일 많은 곳의 박수 횟수 구하는 문제.
// 브실이를 도와 이를 구하자.
// 방법---------------------
// 첫 줄에 n행 m열의 n과 m을 입력 받음.
// 두번째 줄부터 n줄에 걸쳐 박수 횟수에 대한 정보를 입력 받음.
// 마지막 줄에는 브실이가 정한 열의 개수 a가 주어진다.
// 누적합으로 박수 횟수 미리 다 구해놓고, for문으로 범위만큼 윈도우 움직이면서
// 최대 박수 합 갱신해가며 구하고 답을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr29718 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[][] clap = new int[n][m];
		for(int i=0; i<n;  i++) {
			String[] input2 = br.readLine().split(" ");
			for(int j=0; j<m;  j++)
				clap[i][j] = Integer.parseInt(input2[j]);
		}
		int a = Integer.parseInt(br.readLine());
		// 누적합 구해두기
		int[] tmp = new int[m];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++)
				tmp[i] += clap[j][i];
		}
		// 최대 박수 횟수 구하기
		int max = -888484;
		int sum = 0;
		for(int i=0; i<m; i++) {
			sum += tmp[i];										// 윈도우 이동으로 들어오는 줄 +
			if(i>=a)
				sum -= tmp[i - a];								// 윈도우 이동으로 벗어나는 줄 -
			if(i>=a-1)
				max = Math.max(max, sum);
		}
		// 출력
		System.out.print(max);
	}
}