// 백준 1999번
// n * n 행렬 주어지면
// b * b 크기의 부분행렬의  최댓값과 최솟값의 차이를 묻는 질문에 답하는 문제.
// 질문은 k개가 주어짐.
// 방법---------------------
// 첫 줄에 n, b, k가 주어짐.
// 다음 줄부터 n줄에 걸쳐 행렬들이 주어지고
// 그 다음 줄부터 k줄에 걸쳐 질문들이 주어지는데 각 질문들은 i, j로 이루어져있음. (행렬 범위)
// n의 범위가 적으므로 이중for문으로 하나하나 탐색해서 답 구해 출력.
// max min 배열 만들어서 각 행마다 길이 b인 구간의 최대 최소 값을 미리 구해 저장.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] num = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 1; j<=n; j++)
				num[i][j] = Integer.parseInt(st.nextToken());
		}
		// 최댓값과 최솟값 구하기
		int[][] max = new int[n+1][n+1];
		int[][] min = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-b+1; j++) {
				int tmp1 = -1557; int tmp2 = 1557;
				for(int l=0; l<b; l++) {
					if(num[i][j+l] >= tmp1)
						tmp1 = num[i][j+l];
					if(num[i][j+l] <= tmp2)
						tmp2 = num[i][j+l];
				}
				max[i][j] = tmp1; min[i][j] = tmp2;
			}
		}
		// 질문 받고 답 추가하기
		for(int l=0; l<k; l++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int tmp1 = -1557; int tmp2 = 1557;
			for(int m=0; m<b; m++) {
				tmp1 = Math.max(tmp1, max[i+m][j]);
				tmp2 = Math.min(tmp2, min[i+m][j]);
			}
			sb.append(tmp1-tmp2).append('\n');
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}