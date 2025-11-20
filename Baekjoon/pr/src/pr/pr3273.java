// 백준 3273번
// n개의 서로 다른 양의 정수로 이루어진 수열 a가 있음.
// 1 <= ai <= 1000000 임.
// 자연수 x가 주어졌을 때 ai + aj = x 만족하는 ai, aj 쌍 개수 구하기.
// 방법---------------------
// 첫 줄에 수열 크기 n이 주어짐.
// 다음 줄에 수열 a에 포함되는 수들이 주어지고
// 마지막 줄에 x가 입력으로 주어진다.
// 정렬하고 투포인터로 시간초과 피해 쌍 개수 세고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(br.readLine());
		// 정렬
		Arrays.sort(a);
		// 쌍 개수 구하기
		int left = 0, right = n - 1;
		int output = 0;
		while(left < right) {
			int sum = a[left] + a[right];
			if(sum > x)								// ai + aj가 x보다 크면
				right--;							// 오른쪽 범위 좁히기
			else {
				if(sum == x)
					output++;
				left++;
			}
		}
		// 출력
		System.out.print(output);
	}
}