// 백준 2559번
// n일 동안 측정한 온도가 수열로 주어지면
// 온도의 수열에서 연속적인 k일의 온도의 합이 최대가 되는 값을 출력하는 문제.
// 방법---------------------
// 첫 줄에 n과 k를 입력 받고
// 다음 줄에 매일 측정한 온도들을 한 줄에 받음.
// 반복문 돌면서 최댓값 갱신해가며 온도의 합이 최대일 때를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 온도 합 최댓값 구하기
		int output = Integer.MIN_VALUE;
		for(int i=0; i<=n-k; i++){
			int sum = 0;
			for(int j=i; j<i+k; j++)
				sum += num[j];
			output = Math.max(output, sum);
		}
		// 출력
		System.out.print(output);
	}
}