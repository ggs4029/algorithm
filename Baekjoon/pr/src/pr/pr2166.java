// 백준 2166번
// 2차원 평면상에 n개의 점으로 이루어진 다각형의 넓이 구하기
// 방법---------------------
// 첫 줄에 n이 주어지고 그 다음줄부터 n줄에 걸쳐 점의 좌표들이 주어짐
// 신발끈 공식을 사용해 넓이 구하기 - n이 몇인지 모르므로 for문으로 구현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2166 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		long[][] input = new long[n+1][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		// 계산
		long sum1 = 0;
		long sum2 = 0;
		input[n][0] = input[0][0];			// 신발끈 공식 사용을 위한 처리
		input[n][1] = input[0][1];			// 			"
		for(int i=0; i<n; i++) {
			sum1 = sum1 + input[i][0] * input[i+1][1];
			sum2 = sum2 + input[i+1][0] * input[i][1];
		}
		//출력
		System.out.printf("%.1f",Math.abs(sum1-sum2)/2.0);
	}
}