// 백준 7795번
// 두 생명체 A와 B의 크기가 주어졌을 때, A의 크기가 B보다 큰 쌍이 몇 개나 있는지 구하는 문제.
// 방법---------------------
// 첫째 줄에 테스트 케이스의 개수 t가 주어짐.
// 각 테스트 케이스는 세 줄이고 첫째 줄에는 a의 수 n과 b의 수 m이 주어지고
// 둘째 줄에는 a의 크기, 셋째 줄에는 b의 크기가 모두 주어진다.
// b 정렬하고 이분 탐색.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr7795 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			// 입력
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int[] a = new int[n];
			int[] b = new int[m];
			String[] input2 = br.readLine().split(" ");
			for(int j=0; j<n; j++)
				a[j] = Integer.parseInt(input2[j]);
			input2 = br.readLine().split(" ");
			for(int j=0; j<m; j++)
				b[j] = Integer.parseInt(input2[j]);
			// 정렬
			Arrays.sort(b);
			// b보다 큰 쌍 개수 구하기
			int output = 0;
			for(int j=0; j<n; j++) {
				int tmp = bs(b, a[j]);
				output += tmp;
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}
	// 이분 탐색
	public static int bs(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		while(low<=high) {
			int mid = (low + high) / 2;
			if(arr[mid]<target)
                low = mid + 1;
			else
                high = mid - 1;
		}
		return low;
	}
}