// 백준 11689번
// 상근이는 나무를 필요한 만큼만 집으로 가져가려고 한다.
// 이때, 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이 h의 최댓값을 구하는 문제.
// 절단기의 작동 방식은
// 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자.
// 상근이가 높이를 15로 지정했다면, 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고,
// 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것. (즉 목재 길이 7만큼 가지고 감)
// 방법---------------------
// 첫째 줄에 나무의 수 n과 상근이가 집으로 가져가려고 하는 나무의 길이 m을 입력 받음.
// 둘째 줄에 나무의 높이가 n개 주어짐.
// 이분 탐색 메소드를 만들어 이용.
// 절단기의 최대값을 구해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		long m = Long.parseLong(input[1]);
		int[] tree = new int[n];
		String[] input2 = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			tree[i] = Integer.parseInt(input2[i]);
		// 최댓값 구하기
		int h = 0;
		long tmp = 0;
		int high = 0;
		for(int i=0; i<n; i++)
			high = Math.max(high, tree[i]);
		// 출력
		System.out.print(bs(tree, m, high));
	}

	// 이분 탐색
	public static long bs(int[] arr, long m, int high) {
		long output = 0;
		int low = 0;
		while(low<=high) {
			int mid = (low + high) / 2;
			long sum = 0;
			for(int i : arr) {								// h가 mid일때 얻을 수 있는 나무 길이 구하기
				if(i>mid)
					sum += i - mid;
			}
			if(sum>=m) {									// 필요한 목재보다 많으면
				output = mid;								// 톱날 높이 저장하고
				low = mid + 1;								// 범위 확장
			}
			else											// 목재 적으면
				high = mid - 1;								// 높이 낮추기
		}
		return output;
	}
}