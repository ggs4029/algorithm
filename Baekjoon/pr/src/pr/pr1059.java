// 백준 1059번
// 좋은 구간
// 집합 S와 n이 주어지면 n을 포함하는 좋은 구간의 개수를 구하는 문제
// 방법---------------
// 첫째 줄에 집합 S의 크기 L을 받고
// 둘째 줄에는 집합에 포함된 정수들을 받는다.
// 셋째 줄에는 n을 입력받는다.
// 입력받은 집합의 정수들을 sort한 뒤,
// for문을 돌며 좋은 구간의 시작과 끝을 구하고
// 중첩for문을 돌며 좋은 구간들의 수를 센 후 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pr1059 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int L = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] S = new int[L];
		for (int x = 0; x < L; x++)
			S[x] = Integer.parseInt(input[x]);
		int n = Integer.parseInt(br.readLine());
		// 집합 정렬
		Arrays.sort(S);
		// 좋은 구간 찾기
		int sum = 0;
		int start = 0;
		int end = 1001;
		for(int x : S) { // 좋은 구간의 시작과 끝 찾기
			if(x <n) {
				if(x>start)
					start =x;
			}
			else if(x>n) {
				if(x<end)
					end = x;
			}
			else {
				System.out.print(0);
				return;
			}
		}
		for (int y = start + 1; y <= n; y++) { // 구간의 개수를 센다
			for (int z = n; z <= end - 1; z++) {
				if (y != z) {
					sum++;
				}
			}
		}
		// 최종 출력
		System.out.print(sum);
	}
}