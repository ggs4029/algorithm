// 백준 2548번
// 대표 자연수는 주어진 모든 자연수들에 대하여 그 차이를 계산하여 그 차이들 전체의 합을 최소로 하는 자연수이다.
// 연아를 도와서 위의 성질을 만족하는 대표 자연수를 구하는 프로그램을 작성.
// 방법---------------------
// 첫 줄에 자연수의 개수 n을 입력 받음.
// 둘째 줄에 n개의 자연수를 입력 받음.
// 중앙값 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr2548 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 정렬
		Arrays.sort(num);
		// 중앙값 출력
		if(n%2==0)
			System.out.print(num[n/2-1]);
		else
			System.out.print(num[n/2]);
	}
}